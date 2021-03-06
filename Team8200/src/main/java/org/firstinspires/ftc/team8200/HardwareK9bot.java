package org.firstinspires.ftc.team8200;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a K9 robot.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Servo channel:  Servo to raise/lower arm: "arm"
 * Servo channel:  Servo to open/close claw: "claw"
 *
 * Note: the configuration of the servos is such that:
 *   As the arm servo approaches 0, the arm position moves up (away from the floor).
 *   As the claw servo approaches 0, the claw opens up (drops the game element).
 */
public class HardwareK9bot
{

    /* Public OpMode members. */
    public DcMotor leftMotor = null;
    public DcMotor rightMotor = null;
    /*
    public LightSensor lightSensor = null;
    public ColorSensor colorSensor = null;
    public OpticalDistanceSensor distanceSensor = null;
    */
    public DcMotor leftWheelShooter = null;
    public DcMotor rightWheelShooter = null;
    /*
    public DcMotor harvester = null;
    public DcMotor elevator = null;
    */
    //our legacy motor controller
    public DcMotorController legacyController = null;


    public Servo armLeft = null;
    public Servo armRight = null;
    public DeviceInterfaceModule cdim = null;


    /*
    public final static double ARM_HOME = 0.2;
    public final static double ARM_MIN_RANGE  = 0.20;
    public final static double ARM_MAX_RANGE  = 0.90;
    */

    /* Local OpMode members. */
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public HardwareK9bot() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftMotor = hwMap.dcMotor.get("motor_left");
        rightMotor = hwMap.dcMotor.get("motor_right");
        leftWheelShooter = hwMap.dcMotor.get("leftWS");
        rightWheelShooter = hwMap.dcMotor.get("rightWS");

        /*  -- Because we are using a legacy module, we are not using these names at this time ---
        harvester = hwMap.dcMotor.get("harvester");
        elevator = hwMap.dcMotor.get("elevator");
        */
        armLeft = hwMap.servo.get("armLeft");
        armRight = hwMap.servo.get("armRight");
        cdim = hwMap.deviceInterfaceModule.get("dim");
        legacyController = hwMap.dcMotorController.get("legacy_controller");


        leftWheelShooter.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        leftWheelShooter.setPower(0);
        rightWheelShooter.setPower(0);

        /*
        harvester.setPower(0);
        elevator.setPower(0);
        */
        armLeft.setPosition(0);
        armRight.setPosition(1);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Define and initialize ALL sensors
        /*lightSensor = hwMap.lightSensor.get("light");
        colorSensor = hwMap.colorSensor.get("color");

        distanceSensor = hwMap.opticalDistanceSensor.get("distance");
        */
    }

    /*
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    /*
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
        */
    }


