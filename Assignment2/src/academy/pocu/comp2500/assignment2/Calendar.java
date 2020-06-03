package academy.pocu.comp2500.assignment2;

public class Calendar extends Product{
    private CalendarType calendarType;
    private DeliveryMethod deliveryMethod = DeliveryMethod.PICKUP;

    public Calendar(CalendarType calendarType) {
        super(0, 0);
        switch (calendarType) {
            case WALL_CALENDAR:
                this.width = 400;
                this.height = 400;
                this.price = 1000;
                break;
            case DESK_CALENDAR:
                this.width = 200;
                this.height = 150;
                this.price = 1000;
                break;
            case MAGNET_CALENDAR:
                this.width = 100;
                this.height = 200;
                this.price = 1500;
                break;
            default:
                throw new RuntimeException("Wrong CalendarType given");
        }
        this.calendarType = calendarType;
    }

    public CalendarType getCalendarType() {
        return calendarType;
    }

    public String getColor() {
        return "#FFFFFF";
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }
}
