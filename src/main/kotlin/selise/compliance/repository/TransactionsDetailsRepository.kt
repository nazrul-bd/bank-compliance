package selise.compliance.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import selise.compliance.entity.TransactionDetails

@Repository
interface TransactionsDetailsRepository : JpaRepository<TransactionDetails, Long> {

    fun findByTransactionId(transactionId: String): List<TransactionDetails>
}