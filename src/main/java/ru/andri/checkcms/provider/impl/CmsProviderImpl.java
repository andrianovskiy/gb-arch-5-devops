package ru.andri.checkcms.provider.impl;

import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.springframework.stereotype.Service;
import ru.andri.checkcms.dto.CheckCmsResultDto;
import ru.andri.checkcms.provider.CmsProvider;


@Slf4j
@Service
public class CmsProviderImpl implements CmsProvider {

  @Override
  public CheckCmsResultDto checkCms(InputStream inputStream, Long size) {

    try {
      CMSSignedData data = new CMSSignedData(inputStream);
      log.info("CMSSignedData parsed. Is detached signature: " + data.isDetachedSignature());
      CheckCmsResultDto resultDto = new CheckCmsResultDto();
      resultDto.setIsDetachedSignature(data.isDetachedSignature());
      return resultDto;
    } catch (CMSException e) {
      log.error(e.getLocalizedMessage());
      throw new RuntimeException(e);
    }
  }

}
