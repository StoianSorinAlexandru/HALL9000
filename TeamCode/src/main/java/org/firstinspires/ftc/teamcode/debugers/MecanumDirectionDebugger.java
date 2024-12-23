package org.firstinspires.ftc.teamcode.debugers;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Mecanum Direction Debugger", group="Debug")
public class MecanumDirectionDebugger extends LinearOpMode {

    private DcMotor frontLeft, frontRight, backLeft, backRight;

    @Override
    public void runOpMode() {
        // Map motors from configuration
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        // Set correct motor directions
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addLine("Press START to debug motors");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Run individual motors for debugging
            if (gamepad1.a) {
                frontLeft.setPower(0.5);
                telemetry.addLine("Front Left Wheel: FORWARD");
            } else frontLeft.setPower(0);

            if (gamepad1.b) {
                frontRight.setPower(0.5);
                telemetry.addLine("Front Right Wheel: FORWARD");
            } else frontRight.setPower(0);

            if (gamepad1.x) {
                backLeft.setPower(0.5);
                telemetry.addLine("Back Left Wheel: FORWARD");
            } else backLeft.setPower(0);

            if (gamepad1.y) {
                backRight.setPower(0.5);
                telemetry.addLine("Back Right Wheel: FORWARD");
            } else backRight.setPower(0);

            telemetry.update();
        }
    }
}
