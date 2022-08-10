package ru.andri.checkcms.controller;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.andri.checkcms.dto.CheckCmsResultDto;
import ru.andri.checkcms.service.CryptoService;


@Slf4j
@RestController
@RequestMapping("/crypto")
@RequiredArgsConstructor
public class CryptoController {

    private final CryptoService cryptoService;

    @PostMapping(value = "/checkCms", consumes = "multipart/form-data")
    public CheckCmsResultDto checkCmsContainer(@RequestPart("file") MultipartFile file) throws IOException {
        return cryptoService.checkCms(file);
    }

}
