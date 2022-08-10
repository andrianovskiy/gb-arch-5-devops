package ru.andri.checkcms.provider;

import java.io.InputStream;
import ru.andri.checkcms.dto.CheckCmsResultDto;


public interface CmsProvider {

  CheckCmsResultDto checkCms(InputStream inputStream, Long size);

}
