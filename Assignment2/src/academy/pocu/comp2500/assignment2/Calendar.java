package academy.pocu.comp2500.assignment2;

public class Calendar {
    private CalendarType calendarType;
    private int width;
    private int height;
    private int price;
    private DeliveryMethod deliveryMethod = DeliveryMethod.PICKUP;

    //벽걸이(Wall) 달력	40 x 40 cm	흰색	1000
    //탁상(Desk) 달력	20 x 15 cm	흰색	1000
    //자석(Magnet) 달력	10 x 20 cm	흰색	1500
    public Calendar(CalendarType calendarType) {
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return "#FFFFFF";
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }
}
