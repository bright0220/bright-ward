package org.bsoftware.ward.controllers;

import org.bsoftware.ward.components.RestResponseEntityComponent;
import org.bsoftware.ward.dto.implementation.SetupDto;
import org.bsoftware.ward.services.implementation.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * SettingsController displays responses from rest API
 *
 * @author Rudolf Barbu
 * @version 1.0.1
 */
@Validated
@RestController
@RequestMapping(value = "/api/settings")
public class SetupController
{
    /**
     * Autowired SetupService object
     * Used for posting settings information in database
     */
    private final SetupService setupService;

    /**
     * Autowired RestResponseEntityComponent object
     * Used as response wrapper bean, which provides Json headers automatically
     */
    private final RestResponseEntityComponent restResponseEntityComponent;

    /**
     * Posting settings into database
     *
     * @param setupDto dto with data
     * @return OR response with empty body
     */
    @PostMapping
    public ResponseEntity<?> postSetup(@RequestBody @Valid SetupDto setupDto) throws Exception
    {
        return restResponseEntityComponent.wrap(setupService.post(setupDto));
    }

    /**
     * Used for autowiring necessary objects
     *
     * @param setupService autowired SettingsService object
     * @param restResponseEntityComponent autowired RestResponseEntityComponent object
     */
    @Autowired
    public SetupController(SetupService setupService, RestResponseEntityComponent restResponseEntityComponent)
    {
        this.setupService = setupService;
        this.restResponseEntityComponent = restResponseEntityComponent;
    }
}