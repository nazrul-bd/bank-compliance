package selise.compliance.controller

import org.springframework.web.bind.annotation.RestController
import selise.compliance.service.TransactionService

@RestController
class TransactionController(val transaction: TransactionService){

}