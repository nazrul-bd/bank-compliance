package selise.compliance.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import selise.compliance.dto.ResponseDTO
import selise.compliance.dto.TransactionReversalReqDTO
import selise.compliance.service.TransactionReversalService

@RestController
@RequestMapping("/transaction")
class TransactionReversalController(val transaction: TransactionReversalService) {

    @PostMapping("/reverse")
    fun addMoneyRequest(@RequestBody reqDTO: TransactionReversalReqDTO): ResponseEntity<ResponseDTO> {

        val isReversed = transaction.reverseTransaction(reqDTO.transactionId, reqDTO.userId)
        val response = ResponseDTO(200, "", "")
        if (isReversed) {
            response.code = 200
            response.message = "Reversal Success"
            response.data = ""
        } else {
            response.code = 400
            response.message = "Reversal Failed for ${reqDTO.transactionId}"
            response.data = ""
        }
        return ResponseEntity.ok(response)
    }
}