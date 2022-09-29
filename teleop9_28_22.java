package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class teleop extends OpMode {
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private Servo lift;

    @Override
    public void init() {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        lift = hardwareMap.servo.get("lift");

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE); // reverses leftfront motor direction because flipped
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE); // reverses leftback motor direction because flipped

        telemetry.addLine("Initialized");
    }

    @Override
    public void loop() {
        //gamepad1
        double lsx = gamepad1.left_stick_x;
        double lsy = gamepad1.left_stick_y;
        double rsx = gamepad1.right_stick_x;
        double rsy = gamepad1.right_stick_y;


        //turn right
        if (Math.abs(rsx) > 0.05) {
            leftFront.setPower(gamepad1.right_stick_x);
            leftBack.setPower(gamepad1.right_stick_x);
            rightFront.setPower(-gamepad1.right_stick_x);
            rightBack.setPower(-gamepad1.right_stick_x);
        } else {
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
        }
        if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)) {
            leftFront.setPower(-gamepad1.left_stick_y);
            leftBack.setPower(-gamepad1.left_stick_y);
            rightFront.setPower(-gamepad1.left_stick_y);
            rightBack.setPower(-gamepad1.left_stick_y);
        }   else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
            rightFront.setPower(-gamepad1.left_stick_x);
            rightBack.setPower(gamepad1.left_stick_x);
            leftFront.setPower(gamepad1.left_stick_x);
            leftBack.setPower(-gamepad1.left_stick_x);
        } else {
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
        }
       /* if (Math.abs(rsx) < 0.05 && Math.abs(rsy) < 0.05 && Math.abs(lsx) < 0.05 && Math.abs(lsy) < 0.05) {
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
        }*/




        //gamepad2

        if (gamepad2.dpad_down) {
            lift.setPosition(0);
        } else if (gamepad2.dpad_up) {
            lift.setPosition(1);
        }




        telemetry.addData("LeftFront Power", leftFront.getPower());
        telemetry.addData("LeftBack Power", leftBack.getPower());
        telemetry.addData("RightFront Power", rightFront.getPower());
        telemetry.addData("RightBack Power", rightBack.getPower());
        telemetry.addData("lift Position", lift.getPosition());

        telemetry.update();
    }
}
