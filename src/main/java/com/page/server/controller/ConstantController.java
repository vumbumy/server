package com.page.server.controller;

import com.page.server.constant.Action;
import com.page.server.entity.Event;
import com.page.server.entity.Ticket;
import com.page.server.entity.data.Type;
import com.page.server.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ConstantController {
    private final RoleRepository roleRepository;

    @GetMapping("/secured/admin/roles")
    public ResponseEntity<List<String>> getRoles() {
        return ResponseEntity.ok(
                roleRepository.findAll().stream().map(role -> role.value)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/tickets/status")
    public ResponseEntity<Ticket.Status[]> getStatus() {
        return ResponseEntity.ok(
                Ticket.Status.values()
        );
    }

    @GetMapping("/types/data-types")
    public ResponseEntity<Type.DataType[]> getDataTypes() {
        return ResponseEntity.ok(
                Type.DataType.values()
        );
    }

    @GetMapping("/types/events/actions")
    public ResponseEntity<Action[]> getEventActions() {
        return ResponseEntity.ok(
                Action.values()
        );
    }

    @GetMapping("/types/events/status")
    public ResponseEntity<Event.Status[]> getEventStatus() {
        return ResponseEntity.ok(
                Event.Status.values()
        );
    }
}
