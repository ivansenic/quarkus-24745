package io.quarkus;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.lookup.LookupIfProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class DummyServiceConfiguration {

    @Produces
    @ApplicationScoped
    @LookupIfProperty(
            name = "some.prop",
            stringValue = "foo"
    )
    DummyService fooService() {
        return () -> "foo";
    }

    @Produces
    @ApplicationScoped
    @LookupIfProperty(
            name = "some.prop",
            stringValue = "bar"
    )
    DummyService barService() {
        return () -> "bar";
    }

    @Produces
    @ApplicationScoped
    @DefaultBean
    DummyService defaultService() {
        return () -> "default";
    }

}
