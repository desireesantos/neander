package components.instruction.enumcodeinstructions;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 10:31 PM

 Instruction in file:
 00100000   -> Lda
 00001000   [8] = 12
 00110000   -> Add
 00001001   [9] = 13
 00010000   -> Sta
 00001010   [10] => Gravar 25
 */
public enum CodeInstruction {

    NOP("00000000"),
    LDA("00100000"),
    STA("00010000"),
    ADD("00110000"),
    HLT("11110000");

    private String value;

    CodeInstruction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
