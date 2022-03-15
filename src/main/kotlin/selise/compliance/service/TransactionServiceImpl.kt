package selise.compliance.service

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import selise.compliance.entity.TransactionDetails
import selise.compliance.entity.Transactions
import selise.compliance.repository.TransactionsDetailsRepository
import selise.compliance.repository.TransactionsRepository
import selise.compliance.repository.UserRepository
import java.sql.SQLException
import java.util.*
import javax.transaction.Transactional

@Service
@Slf4j
class TransactionServiceImpl(
    val transactionRepository: TransactionsRepository,
    val userRepo: UserRepository,
    val transDetails: TransactionsDetailsRepository
) : TransactionService, TransactionReversalService {

    @Transactional
    override fun addMoney(userId: Long, fromAcct: String, toAcct: String, amount: Double, remarks: String): Boolean {

        // Transaction Model Mapper
        val transaction = transactionModelMapper(userId, fromAcct, toAcct, amount, remarks)

        try {
            if (transaction != null) {
                // Saving Main Transaction
                val transId = transactionRepository.save(transaction).id
                // Saving Transaction Details
                var details = TransactionDetails(
                    null, transId.toString(), null, amount, "CUST_GL", "CREDIT", "CUSTOMER GL TRANSFER", null
                )
                transDetails.save(details)
                userCurrentBalanceUpdate(fromAcct, amount, toAcct)

            }
        } catch (e: SQLException) {
            // Exception Not Handled
        }
        return false
    }

    private fun userCurrentBalanceUpdate(fromAcct: String, amount: Double, toAcct: String) {

        // Updating the Debit/From Account Balance
        val userInfoDebit = userRepo.findByAcctNo(fromAcct)
        if (userInfoDebit != null) {
            userInfoDebit.currentBalance -= amount
            userRepo.save(userInfoDebit)
        }
        // Updating the Credit/To Account Balance
        val userInfoCredit = userRepo.findByAcctNo(toAcct)
        if (userInfoCredit != null) {
            userInfoCredit.currentBalance += amount
            userRepo.save(userInfoCredit)
        }
    }

    fun transactionModelMapper(
        userId: Long, fromAcct: String, toAcct: String, amount: Double, remarks: String
    ): Transactions? {

        val user = userRepo.findById(userId)
        if (user.isPresent) return Transactions(
            null,
            user.get(),
            fromAcct,
            amount,
            toAcct,
            remarks,
            null,
            "SUCCESS",
            "test transaction",
            user.get().id,
            null
        )
        else return null

    }

    override fun reverseTransaction(transactionId: String, userId: Long): Boolean {

        // Find the actual faulty transaction that will be reversed
        val user = userRepo.findById(userId)
        val transaction = transactionRepository.findByTransactionId(transactionId)
        val details = transDetails.findByTransactionId(transaction.transactionId)

        // Make the transaction status REVERSED at the END

        // Make a new transaction making the DEBIT acct to CREDIT and vice versa
        try {
            if (transaction != null) {
                // Saving Main Transaction
                val reversedTransId = Transactions(
                    null,
                    user.get(),
                    UUID.randomUUID().toString(),
                    transaction.amount,
                    transaction.toAccount,
                    transaction.fromAccount,
                    null,
                    "REVERSAL",
                    "Its a reversal transaction",
                    user.get().id,
                    null
                )
                // Saving Reversed Transaction Details
                details.parallelStream().forEach({
                    val tempAmount = it.amount - transaction.amount
                    val details = TransactionDetails(
                        null,
                        reversedTransId.toString(),
                        reversedTransId.transactionId,
                        tempAmount,
                        "CUST_GL",
                        "DEBIT",
                        "CUSTOMER GL REVERSE TRANSACTION",
                        null
                    )
                    transDetails.save(details)
                })
                // update user current balance
                userCurrentBalanceUpdate(transaction.toAccount, transaction.amount, transaction.fromAccount)
            }
        } catch (e: SQLException) {
            // Exception Not Handled
        }
        // and all the Details Transactions DEBIT to CREDIT and vice versa
        return true
    }


}