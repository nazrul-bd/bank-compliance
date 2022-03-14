package selise.compliance.service

interface TransactionReversalService {
    fun reverseTransaction(transactionId: String): Boolean
}