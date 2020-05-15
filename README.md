# Electro-mechanical computer simulation
This project is a simulation of a computer based upon logic gates constructed from telegraph relays. The inspiration and design of the computer come from Charles Petzold's book *<span style="text-decoration: underline;">CODE: The Hidden Language of Computer Hardware and Software</span>.*

## Machine implementations
There are several different machines implemented in this project. Each of these machines corresponds to one of the machines described in Charles Petzold's book. Most of these machines cannot be classified as *computers,* but represent stepping stones on the way to the implementation of an actual computer.

### ELECTRO-MECHANICAL COMPUTER V. 1.0
![alt text](https://github.com/PerriNelson/electromechanicalcomputersimulation/blob/master/electro-mechanical%20computer%20v.%201.0.png "Electro-mechanical computer v. 1.0 user interface")

This machine implementation is a complete implementation of the computer described in chapter 17 of Charles Petzold's book, plus three additional bitwise operators.

This is not a fast computer. Each clock cycle takes several milliseconds, where modern electronic computers have clock cycles on the order of nanoseconds. There is an additional pause of 10 milliseconds between each clock cycle. A simple multiplication program operating by repeated addition can take most of a day to run, and on slower computers can actually take even longer to run. The reason for this machine isn't *speed*, but to demonstrate how a computer works from the ground up.

#### Instruction set
These instructions require three bytes, the opcode, the high-order byte of the 16-bit address, and the low order byte of the 16-bit address. The instruction mnemonic code, hexadecimal opcode, binary opcode, and description are given in order for each instruction.

| Mnemonic | Hex opcode | Binary Opcode | Description |
| --- | --- | --- | --- |
| LOD | 10 | 0001 0000 | Load byte into accumulator |
| STO | 11 | 0001 0001 | Store byte in accumulator to memory |
| ADD | 20 | 0010 0000 | Add byte to accumulator |
| SUB | 21 | 0010 0001 | Subtract byte from accumulator |
| ADC | 22 | 0010 0010 | Add byte to accumulator, with carry input |
| SBB | 23 | 0010 0011 | Subtract byte from accumulator, with borrow |
| JMP | 30 | 0011 0000 | Unconditional jump |
| JZ | 31 | 0011 0001 | Jump if zero |
| JC | 32 | 0011 0010 | Jump if carry |
| JNZ | 33 | 0011 0011 | Jump if not zero |
| JNC | 34 | 0011 0100 | Jump if not carry |
| OR | 40 | 0100 0000 | Bitwise OR byte in accumulator with memory |
| AND | 41 | 0100 0001 | Bitwise AND byte in accumulator with memory |
| XOR | 42 | 0100 0010 | Bitwise XOR byte in accumulator with memory |

These instructions require one byte, the Opcode.
| Mnemonic | Hex opcode | Binary Opcode | Description |
| --- | --- | --- | --- |
| HLT | ff | 1111 1111 | Halt processor |

#### Operation of the computer
This computer uses a primitive interface consisting of a control panel with toggle switches for inputs and lamps for outputs. To enter and run a new program:

1. Flip the "RESET" switch into the "ON" position (up).
2. Flip the "TAKE OVER" switch into the "ON" position. The control panel is now ready for you to enter your program.
3. Enter the address where you wish to store a byte of data by flipping the appropriate switches labeld "A0" through "AF" (from right to left) into the "ON" or "OFF" (down) position.
4. Specify the byte of data by flipping the appropriate switches labeled "D0" through "D7" into the "ON" or "OFF" position.
5. Enter the byte of data into memory by flipping the "WRITE" switch into the "ON" position. The row of lamps beneath the data switches ("D0" through "D7") will light up indicating which bits of the memory location are on and which are off. They should match the data switch positions, each switch that is on should have a corresponding lit lamp.
6. Flip the "WRITE" switch into the "OFF" position before entering your next address or data byte. If you fail to do this you will be writing the byte corresponding to the data switches into each address corresponding to the address switches as you toggle the address or data switches. This can potentially overwrite data that you have already entered.
7. Repeat steps 3 through 5, entering each byte of the program into memory.
8. Flip the "TAKE OVER" switch into the "OFF" position.
9. Flip the "RESET" switch into the "OFF" position. Your program will now run. If you have entered everything correctly using the switches you will see the bank of lamps at the bottom fo the control panel start flashing for a while. If your program runs to completion (in other words, it reaches a HLT instruction during a code fetch cycle) the bank of lamps will stop flashing and the "HALT" lamp will turn on. This is your indication that your program has completed execution.
10. Flip the "RESET" switch into the "ON" position. This will prevent the computer from performing random operations while you inspect the results.
11. Flip the "TAKE OVER" switch into the "ON" position. The control panel switches are now active.
12. Inspect the results of running your program by entering the addresses of the bytes you wish to inspect on the bank of address switches. As each switch is toggled the byte at the memory location corresponding to the address switches will be displayed on the bank of data lamps.


