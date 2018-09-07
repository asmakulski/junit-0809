package pl.codeleak.samples.unit_testing.product;

class LoggingProductEventPublisher implements ProductEventPublisher {
    @Override
    public void publishEvent(String eventDetails) {
        System.out.println("LoggingProductEventPublisher.publishEvent: " + eventDetails);
    }
}
