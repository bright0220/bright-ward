package org.bsoftware.ward.services;

import org.bsoftware.ward.Ward;
import org.bsoftware.ward.components.UtilitiesComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ErrorService displays error pages of Ward application
 *
 * @author Rudolf Barbu
 * @version 1.0.1
 */
@Service
public class ErrorService
{
    /**
     * Autowired UtilitiesComponent object
     * Used for various utility functions
     */
    private final UtilitiesComponent utilitiesComponent;

    /**
     * Returns 404 error page
     *
     * @param httpServletResponse current responce
     * @param model container for strings
     * @return template name
     * @throws IOException if ini file is unreachable
     */
    public String getError(HttpServletResponse httpServletResponse, Model model) throws IOException
    {
        if (Ward.isFirstLaunch())
        {
            return "setup";
        }

        model.addAttribute("theme", utilitiesComponent.getThemeName());
        return "error/404";
    }

    /**
     * Used for autowiring necessary objects
     *
     * @param utilitiesComponent autowired UtilitiesComponent object
     */
    @Autowired
    public ErrorService(UtilitiesComponent utilitiesComponent)
    {
        this.utilitiesComponent = utilitiesComponent;
    }
}