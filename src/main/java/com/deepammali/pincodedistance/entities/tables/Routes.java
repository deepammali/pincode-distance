package com.deepammali.pincodedistance.entities.tables;

import java.util.List;

import com.deepammali.pincodedistance.entities.embedable.Route;

import lombok.Getter;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue
    private Long routesId;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "routes_list", joinColumns = @JoinColumn(name = "routes_id"))
    private List<Route> routes;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Origin origin;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public Routes(List<Route> routes, Origin origin, Destination destination) {
        this.routes = routes;
        this.origin = origin;
        this.destination = destination;
    }

}
