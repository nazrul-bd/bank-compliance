package selise.compliance.entity

import javax.persistence.*

@Entity
@Table(name = "transaction_type")
class TransactionType(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    @Column(name = "transaction_type") val transType: String,
    @OneToMany(mappedBy = "transType") val transactions: List<Transactions>
)