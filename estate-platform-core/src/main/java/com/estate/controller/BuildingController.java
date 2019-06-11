package com.estate.controller;

import com.estate.constant.SystemConstant;
import com.estate.dto.BuildingDTO;

import com.estate.dto.UserDTO;
import com.estate.service.IBuildingService;
import com.estate.service.IDistrictService;
import com.estate.service.IUserService;
import com.estate.utils.MessageResponseUtils;
import com.estate.utils.SecurityUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private IUserService userService;



    @RequestMapping(value = {"/admin/building/list","/admin/building/assignment"}, method = RequestMethod.GET)
    public ModelAndView showBuildings(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                                                  HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        model.setUrlMapping(request.getServletPath());
        List<BuildingDTO> buildings = buildingService.findAll(model, new PageRequest(model.getPage() -1, model.getMaxPageItems()));
        model.setListResult(buildings);
        model.setTotalItems(buildingService.getTotalItems(model));
        initMessageResponse(mav, request);
        mav.addObject("staff", userService.getUsers());
        mav.addObject("districts", districtService.getDistricts());
        mav.addObject("types", buildingService.getBuildingTypes());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }



    @RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
    public ModelAndView editNew(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        if (id != null) {
            model = buildingService.findById(id);
        }
        initMessageResponse(mav, request);
        mav.addObject("districts", districtService.getDistricts());
        mav.addObject("types", buildingService.getBuildingTypes());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/building/priority/list", method = RequestMethod.GET)
    public ModelAndView showBuildingPriority(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model) {
        ModelAndView mav = new ModelAndView("admin/building/priority/list");
        long userId = SecurityUtils.getPrincipal().getId();
        List<BuildingDTO> buildings = buildingService.findAllPriorities(userId, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        model.setListResult(buildings);
        model.setTotalItems(buildingService.getTotalItemPriorities(userId));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }


    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (StringUtils.isNotBlank(message)) {
            Map<String, String> messageResponse = MessageResponseUtils.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageResponse.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageResponse.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }
}
