package de.jotomo.ruffy.spi;

import de.jotomo.ruffy.spi.history.PumpHistoryRequest;

public interface RuffyCommands {
    /** Issues a bolus issues updates on progress through via {@link BolusProgressReporter}. */
    CommandResult deliverBolus(double amount, BolusProgressReporter bolusProgressReporter);

    /** Requests cancellation of an active bolus if possible. */
    void cancelBolus();

    CommandResult setTbr(int percent, int duration);

    CommandResult cancelTbr();

    /** Confirms an active warning alert on the pump.
     * @see PumpWarningCodes */
    CommandResult confirmAlert(int warningCode);

    /** Indicate if the pump is ready to receive commands. */
    boolean isPumpAvailable();

    /** Indicate of the pump is busy processing a command. */
    boolean isPumpBusy();

    /** Read the state of the pump, which encompasses all information displayed on the main menu. */
    CommandResult readPumpState();

    /** Read revervoir level and last bolus via Quick Info */
    CommandResult readReservoirLevelAndLastBolus();

    /** Reads pump history via the My Data menu. The {@link PumpHistoryRequest} specifies
     * what types of data and how far back data is returned. */
    CommandResult readHistory(PumpHistoryRequest request);

    CommandResult readBasalProfile();

    CommandResult setBasalProfile(BasalProfile basalProfile);

    CommandResult getDateAndTime();

    CommandResult setDateAndTime();

    // TODO below methods are drafts
    void requestPairing();

    /** Send the key displayed on the pump during pairing/bonding. */
    void sendAuthKey(String key);

    void unpair();
}

