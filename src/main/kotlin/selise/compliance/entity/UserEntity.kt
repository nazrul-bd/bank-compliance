package selise.compliance.entity

import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    val name: String,
    val customerId: String,
    val accountNo: String,
    var currentBalance: Double
)