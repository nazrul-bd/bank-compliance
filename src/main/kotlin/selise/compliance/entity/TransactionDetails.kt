package selise.compliance.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "transaction_details")
class TransactionDetails(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
     val transactionId: String,
    @Column(name = "reversedTransId") val reversedTransactionId: String?,
    val amount: Double,
    val glAccount: String,
    val operationType: String,
    val remarks: String,
    val createdDate: LocalDateTime? = LocalDateTime.now()
)