package selise.compliance.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import selise.compliance.dto.AddMoneyReqDTO
import selise.compliance.dto.ResponseDTO
import selise.compliance.service.TransactionService

@RestController
@RequestMapping("/customer/v1")
class TransactionController(val transaction: TransactionService) {

    @PostMapping("/add-money")
    fun addMoneyRequest(@RequestBody reqDTO: AddMoneyReqDTO): ResponseEntity<ResponseDTO> {

        val transId =
            transaction.addMoney(reqDTO.userId, reqDTO.fromAcct, reqDTO.toAcct, reqDTO.amount, "Dollar Vanganu")
        val response = ResponseDTO(200, "", "")
        if (!transId.isEmpty()) {
            response.code = 200
            response.message = "Success"
            response.data = "transId: $transId"
        } else {
            response.code = 400
            response.message = "Failed"
            response.data = ""
        }
        return ResponseEntity.ok(response)
    }
}