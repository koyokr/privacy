package com.rs.privacy.service;

import com.rs.privacy.model.CategoryType;
import com.rs.privacy.model.PrivacyInfo;
import com.rs.privacy.repository.PrivacyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivacyInfoService {

    private final PrivacyInfoRepository privacyInfoRepository;

    @Autowired
    public PrivacyInfoService(PrivacyInfoRepository privacyInfoRepository) {
        this.privacyInfoRepository = privacyInfoRepository;
    }

    public PrivacyInfo getPrivacyIs() {
        return privacyInfoRepository.findByCategory(CategoryType.PRIVACY_IS.getViewName());
    }

    public List<PrivacyInfo> getPrivacyRulesList() {

        List<PrivacyInfo> privacyRules = privacyInfoRepository.findAll().stream()
                .filter(privacyInfo -> privacyInfo.getCategory().equals(CategoryType.PRIVACY_RULES.getViewName())).collect(Collectors.toList());

        return privacyRules;
    }
}
