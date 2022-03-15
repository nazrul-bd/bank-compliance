package selise.compliance.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "transactions")
class Transactions(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @ManyToOne @JoinColumn(name = "user_id") val userId: UserEntity,
    val transactionId: String,
    val amount: Double,
    val fromAccount: String,
    val toAccount: String,
    @ManyToOne @JoinColumn(name = "transType") val transType: TransactionType? = null,
    val status: String,
    val remarks: String,
    val createdBy: Long,
    val createdDate: LocalDateTime? = LocalDateTime.now()
)