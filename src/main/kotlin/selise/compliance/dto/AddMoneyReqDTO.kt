package selise.compliance.dto

class AddMoneyReqDTO(val userId: Long, val fromAcct: String, val toAcct: String, val amount: Double, val remarks: String)