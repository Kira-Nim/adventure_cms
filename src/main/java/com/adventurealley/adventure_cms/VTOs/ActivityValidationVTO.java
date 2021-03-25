package com.adventurealley.adventure_cms.VTOs;



public class ActivityValidationVTO {

    private boolean validTitle;
    private boolean validDescription;
    private boolean validPrice;
    private boolean validDurationMinutes;
    private boolean validMinAge;
    private boolean validMaxParticipants;
    private boolean validPhotoURL;
    private boolean statusCode;

    public boolean getIsValidTitle() { return validTitle; }
    public void setValidTitle(boolean validTitle) { this.validTitle = validTitle; }

    public boolean getIsValidDescription() { return validDescription; }
    public void setValidDescription(boolean validDescription) { this.validDescription = validDescription; }

    public boolean getIsValidPrice() { return validPrice; }
    public void setValidPrice(boolean validPrice) { this.validPrice = validPrice; }

    public boolean getIsValidDurationMinutes() { return validDurationMinutes; }
    public void setValidDurationMinutes(boolean validDurationMinutes) { this.validDurationMinutes = validDurationMinutes; }

    public boolean getIsValidMinAge() { return validMinAge; }
    public void setValidMinAge(boolean validMinAge) { this.validMinAge = validMinAge; }

    public boolean getIsValidMaxParticipants() { return validMaxParticipants; }
    public void setValidMaxParticipants(boolean validMaxParticipants) { this.validMaxParticipants = validMaxParticipants; }

    public boolean getIsValidPhotoURL() { return validPhotoURL; }
    public void setValidPhotoURL(boolean vPhotoURL) { this.validPhotoURL = vPhotoURL; }

    public boolean getStatusCode() { return statusCode; }
    public void setStatusCode(boolean statusCode) { this.statusCode = statusCode; }
}
