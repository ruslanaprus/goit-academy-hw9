package org.example.customclass;

import java.time.LocalDate;
import java.util.Objects;

public class EmailAddress {
    private int customerId;
    private User user;
    private String status;
    private LocalDate creationDate;
    private boolean isPrimary;

    public EmailAddress(int customerId, User user, String status, LocalDate creationDate, boolean isPrimary) {
        this.customerId = customerId;
        this.user = user;
        this.status = status;
        this.creationDate = creationDate;
        this.isPrimary = isPrimary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmailAddress emailAddress = (EmailAddress) obj;
        return this.isPrimary == emailAddress.isPrimary &&
                this.customerId == emailAddress.customerId &&
                Objects.equals(this.user, emailAddress.user) &&
                Objects.equals(this.status, emailAddress.status) &&
                Objects.equals(this.creationDate, emailAddress.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, user, status, creationDate, isPrimary);
    }

    @Override
    public String toString() {
        return "[" + customerId + " - " + user + "]";
    }

}
