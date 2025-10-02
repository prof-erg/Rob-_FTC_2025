package org.firstinspires.ftc.teamcode;  
// Pacote onde o código ficará (normalmente "teamcode")

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;  
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;  
import com.qualcomm.robotcore.hardware.DcMotor;  
// Importações necessárias para programar um OpMode autônomo e usar motores

@Autonomous(name="Andar em Linha Reta", group="Autonomous")  
// Define que este é um modo AUTONÔMO, com o nome "Andar em Linha Reta"
// Ele vai aparecer na lista de OpModes do Driver Hub

public class AndarEmLinhaReta extends LinearOpMode {
    // A classe herda de LinearOpMode, que permite programar passo a passo (linear)

    // Declaração dos motores do robô
    private DcMotor motorEsquerdo;
    private DcMotor motorDireito;

    @Override
    public void runOpMode() {

        // "hardwareMap" conecta os nomes configurados no Driver Hub aos motores físicos
        motorEsquerdo = hardwareMap.get(DcMotor.class, "motorEsquerdo");
        motorDireito = hardwareMap.get(DcMotor.class, "motorDireito");

        // Define a direção dos motores
        // Pode ser FORWARD (frente) ou REVERSE (trás)
        // Isso depende de como o motor foi montado no robô
        motorEsquerdo.setDirection(DcMotor.Direction.FORWARD);
        motorDireito.setDirection(DcMotor.Direction.REVERSE);

        // Espera o operador apertar "START" no Driver Hub
        waitForStart();

        // Verifica se o modo está ativo (START foi apertado e não foi parado)
        if (opModeIsActive()) {

            // Define potência nos motores: 0.5 = 50% da potência máxima
            // Valores podem ir de -1.0 (ré) até +1.0 (frente)
            motorEsquerdo.setPower(0.5);
            motorDireito.setPower(0.5);

            // Mantém os motores ligados por 2000 milissegundos (2 segundos)
            sleep(2000);

            // Para os motores (potência 0 = desligado)
            motorEsquerdo.setPower(0);
            motorDireito.setPower(0);
        }
    }
}
