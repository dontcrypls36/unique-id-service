package apozdnyakov.interview.uniqueidservice.controller;

import apozdnyakov.interview.uniqueidservice.model.Response;
import apozdnyakov.interview.uniqueidservice.service.UniqueIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/uniqueId")
public class UniqueIdController {

    @Autowired
    private UniqueIdService uniqueIdService;

    @GetMapping
    public Response getUniqueId() {
        return uniqueIdService.getUniqueIdentifier();
    }
}
