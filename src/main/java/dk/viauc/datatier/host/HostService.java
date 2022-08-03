package dk.viauc.datatier.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostService {
    private final HostRepository hostRepository;

    @Autowired
    public HostService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public void addHost(Host host) {
        Optional<Host> hostOptional = hostRepository.findHostByEmail(host.getEmail());

        if (hostOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }

        hostRepository.save(host);
    }

    public List<Host> getHosts() {
        return hostRepository.findAll();
    }
}
