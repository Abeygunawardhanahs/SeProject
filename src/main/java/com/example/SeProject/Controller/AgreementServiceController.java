package com.example.SeProject.Controller;


import com.example.SeProject.Dto.AgreementServiceDto;
import com.example.SeProject.Dto.ResponseDto;
import com.example.SeProject.Service.AgreementServiceSer;
import com.example.SeProject.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/agreementService")
public class AgreementServiceController {
    @Autowired
    private AgreementServiceSer agreementServiceSer;

    @Autowired
    private ResponseDto responseDto;
    @PatchMapping(value ="/saveAgreementService")
    public ResponseEntity saveAgreementService(@RequestBody AgreementServiceDto agreementServiceDto){
        try {
            String res = agreementServiceSer.saveAgreementService(agreementServiceDto);
            if (res.equals("00")){
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Success");
                responseDto.setContent(agreementServiceDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);

            }
            else if (res.equals("06")){
                responseDto.setCode(VarList.RSP_DUPLICATED);
                responseDto.setMessage("Registered");
                responseDto.setContent(agreementServiceDto);
                return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);

            }
            else {
                responseDto.setCode(VarList.RSP_FAIL);
                responseDto.setMessage("Error");
                responseDto.setContent(null);
                return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);

            }

        }catch (Exception ex){
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
