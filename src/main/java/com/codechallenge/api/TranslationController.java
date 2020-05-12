package com.codechallenge.api;

import com.codechallenge.model.Translation;
import com.codechallenge.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("translations")
@RestController
public class TranslationController {
    private final TranslationService translationService;

    @Autowired // Dependency injection with spring
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }
    @GetMapping
    public List<Translation> getAllTranslations(){
        return translationService.getAllTranslations();
    }
    @GetMapping(value = "{lang}/{originalLang}")
    public List<Translation> getTranslation(@PathVariable String lang,@PathVariable String originalLang){
        return translationService.getTranslation(originalLang,lang);
    }
    @PostMapping
    public void addTranslation(@Valid @NonNull @RequestBody Translation translation){
        translationService.insertTranslation(translation);
    }

}
