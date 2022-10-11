package shop.kokodo.memberservice.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.kokodo.memberservice.feign.repository.MemberFeignRepository;
import shop.kokodo.memberservice.feign.response.FeignResponse;
import shop.kokodo.memberservice.feign.response.FeignResponse.MemberAddress;
import shop.kokodo.memberservice.feign.response.FeignResponse.MemberOfOrderSheet;
import shop.kokodo.memberservice.feign.service.interfaces.MemberFeignService;

@Service
public class MemberFeignServiceImpl implements MemberFeignService {

    private final MemberFeignRepository memberFeignRepository;

    @Autowired
    public MemberFeignServiceImpl(
        MemberFeignRepository memberFeignRepository) {
        this.memberFeignRepository = memberFeignRepository;
    }

    @Override
    public FeignResponse.MemberAddress getMemberAddress(Long memberId) {
        return memberFeignRepository.findById(memberId, MemberAddress.class);
    }

    @Override
    public MemberOfOrderSheet getMemberOrderInfo(Long memberId) {
        return memberFeignRepository.findById(memberId, MemberOfOrderSheet.class);
    }
}
