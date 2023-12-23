package study.cicdpractice.controller;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.cicdpractice.domain.dto.VisitCreateRequest;
import study.cicdpractice.domain.entity.Visit;
import study.cicdpractice.repository.VisitRepository;

@Controller
@RequiredArgsConstructor
public class VisitController {

    private final VisitRepository visitRepository;

    @GetMapping("")
    public String home(Model model,
                       @PageableDefault(size = Integer.MAX_VALUE, sort = "visitTime", direction = Sort.Direction.DESC)Pageable pageable) {
        Page<Visit> visits = visitRepository.findAll(pageable);
        model.addAttribute("visits", visits);
        model.addAttribute("visitCnt", visits.getTotalElements());
        model.addAttribute("visitCreateRequest", new VisitCreateRequest());
        return "home";
    }

    @PostMapping("/visit")
    public String visit(@ModelAttribute VisitCreateRequest visitCreateRequest) {
        visitRepository.save(visitCreateRequest.toEntity());
        return "redirect:/";
    }
}
