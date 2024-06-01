package com.example.SeProject.Service;

import com.example.SeProject.Dto.AgreementServiceDto;
import com.example.SeProject.Entity.AgreementService;
import com.example.SeProject.Repo.AgreementServiceRepo;
import com.example.SeProject.Util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class AgreementServiceSer {

    @Autowired
    private AgreementServiceRepo agreementServiceRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveAgreementService(AgreementServiceDto agreementServiceDto){
        if (agreementServiceRepo.existsById(agreementServiceDto.getAgreementServiceId())){
            return VarList.RSP_DUPLICATED;

        }
        else{
            agreementServiceRepo.save(modelMapper.map(agreementServiceDto, AgreementService.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
