package com.yazlab.coachingApp.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
