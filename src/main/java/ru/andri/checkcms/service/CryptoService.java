package ru.andri.checkcms.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.andri.checkcms.dto.CheckCmsResultDto;
import ru.andri.checkcms.provider.CmsProvider;
import java.io.IOException;
import java.io.InputStream;


@Slf4j
@RequiredArgsConstructor
@Service
public class CryptoService {

    private final CmsProvider cmsProvider;

    public CheckCmsResultDto checkCms(MultipartFile file) throws IOException {
        try (InputStream input = file.getInputStream()) {
            return cmsProvider.checkCms(input, file.getSize());
        }
    }

}
