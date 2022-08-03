package dk.viauc.datatier.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/hosts")
@RestController
public class HostController {
    private final HostService hostService;

    @Autowired
    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public void createHost(@RequestBody @Valid Host host) {
        hostService.addHost(host);
    }

    @GetMapping
    public List<Host> getHosts() {
        return hostService.getHosts();
    }
}
