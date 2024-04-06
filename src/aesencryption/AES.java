/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aesencryption;

/**
 *
 * @author Anhho
 */
//import java.nio.charset.StandardCharsets;
//
//public class AES {
//
//    private static final int BlockSize = 16;
//
//    public static byte[] Encrypt(String plainText, String key) {
//        byte[] plainBytes = plainText.getBytes(StandardCharsets.UTF_8);
//        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
//
//        byte[][] state = new byte[4][4];
//        for (int i = 0; i < 4; i++) {
//            state[i] = new byte[4];
//        }
//
//        for (int i = 0; i < Math.min(plainBytes.length, BlockSize); i++) {
//            state[i % 4][i / 4] = plainBytes[i];
//        }
//
//        byte[][] w = KeyExpansion(keyBytes);
//
//        AddRoundKey(state, w, 0);
//
//        for (int round = 1; round < 10; round++) {
//            SubBytes(state);
//            ShiftRows(state);
//            MixColumns(state);
//            AddRoundKey(state, w, round);
//        }
//
//        SubBytes(state);
//        ShiftRows(state);
//        AddRoundKey(state, w, 10);
//
//        byte[] cipherBytes = new byte[BlockSize];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                cipherBytes[i * 4 + j] = state[j][i];
//            }
//        }
//
//        return cipherBytes;
//    }
//
//    public static String Decrypt(byte[] cipherText, String key) {
//        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
//
//        byte[][] state = new byte[4][4];
//        for (int i = 0; i < 4; i++) {
//            state[i] = new byte[4];
//        }
//
//        for (int i = 0; i < Math.min(cipherText.length, BlockSize); i++) {
//            state[i % 4][i / 4] = cipherText[i];
//        }
//
//        byte[][] w = KeyExpansion(keyBytes);
//
//        AddRoundKey(state, w, 10);
//
//        for (int round = 9; round > 0; round--) {
//            InvShiftRows(state);
//            InvSubBytes(state);
//            AddRoundKey(state, w, round);
//            InvMixColumns(state);
//        }
//
//        InvShiftRows(state);
//        InvSubBytes(state);
//        AddRoundKey(state, w, 0);
//
//        byte[] plainBytes = new byte[BlockSize];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                plainBytes[i * 4 + j] = state[j][i];
//            }
//        }
//
//        return new String(plainBytes, StandardCharsets.UTF_8);
//    }
//
//    private static void SubBytes(byte[][] state) {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                state[i][j] = SBox[state[i][j] & 0xFF];
//            }
//        }
//    }
//
//    private static void InvSubBytes(byte[][] state) {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                state[i][j] = InvSBox[state[i][j] & 0xFF];
//            }
//        }
//    }
//
//    private static void ShiftRows(byte[][] state) {
//        for (int i = 1; i < 4; i++) {
//            for (int j = 0; j < i; j++) {
//                byte temp = state[i][0];
//                System.arraycopy(state[i], 1, state[i], 0, 3);
//                state[i][3] = temp;
//            }
//        }
//    }
//
//    private static void InvShiftRows(byte[][] state) {
//        for (int i = 1; i < 4; i++) {
//            for (int j = 0; j < i; j++) {
//                byte temp = state[i][3];
//                System.arraycopy(state[i], 0, state[i], 1, 3);
//                state[i][0] = temp;
//            }
//        }
//    }
//
//    private static void MixColumns(byte[][] state) {
//        byte[][] temp = new byte[4][4];
//
//        for (int i = 0; i < 4; i++) {
//            temp[0][i] = (byte) (Multiply((byte) 0x02, state[0][i]) ^ Multiply((byte) 0x03, state[1][i]) ^ state[2][i] ^ state[3][i]);
//            temp[1][i] = (byte) (state[0][i] ^ Multiply((byte) 0x02, state[1][i]) ^ Multiply((byte) 0x03, state[2][i]) ^ state[3][i]);
//            temp[2][i] = (byte) (state[0][i] ^ state[1][i] ^ Multiply((byte) 0x02, state[2][i]) ^ Multiply((byte) 0x03, state[3][i]));
//            temp[3][i] = (byte) (Multiply((byte) 0x03, state[0][i]) ^ state[1][i] ^ state[2][i] ^ Multiply((byte) 0x02, state[3][i]));
//        }
//
//        for (int i = 0; i < 4; i++) {
//            System.arraycopy(temp[i], 0, state[i], 0, 4);
//        }
//    }
//
//    private static void InvMixColumns(byte[][] state) {
//        byte[][] temp = new byte[4][4];
//
//        for (int i = 0; i < 4; i++) {
//            temp[0][i] = (byte) (Multiply((byte) 0x0E, state[0][i]) ^ Multiply((byte) 0x0B, state[1][i]) ^ Multiply((byte) 0x0D, state[2][i]) ^ Multiply((byte) 0x09, state[3][i]));
//            temp[1][i] = (byte) (Multiply((byte) 0x09, state[0][i]) ^ Multiply((byte) 0x0E, state[1][i]) ^ Multiply((byte) 0x0B, state[2][i]) ^ Multiply((byte) 0x0D, state[3][i]));
//            temp[2][i] = (byte) (Multiply((byte) 0x0D, state[0][i]) ^ Multiply((byte) 0x09, state[1][i]) ^ Multiply((byte) 0x0E, state[2][i]) ^ Multiply((byte) 0x0B, state[3][i]));
//            temp[3][i] = (byte) (Multiply((byte) 0x0B, state[0][i]) ^ Multiply((byte) 0x0D, state[1][i]) ^ Multiply((byte) 0x09, state[2][i]) ^ Multiply((byte) 0x0E, state[3][i]));
//        }
//
//        for (int i = 0; i < 4; i++) {
//            System.arraycopy(temp[i], 0, state[i], 0, 4);
//        }
//    }
//
//    private static void AddRoundKey(byte[][] state, byte[][] w, int round) {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                state[j][i] ^= w[round * 4 + i][j];
//            }
//        }
//    }
//
//    private static byte Multiply(byte a, byte b) {
//        byte result = 0;
//        byte highBit = 0;
//        for (int i = 0; i < 8; i++) {
//            if ((b & 1) == 1) {
//                result ^= a;
//            }
//            highBit = (byte) (a & 0x80);
//            a <<= 1;
//            if (highBit == 0x80) {
//                a ^= 0x1B;
//            }
//            b >>= 1;
//        }
//        return result;
//    }
//
//    private static byte[][] KeyExpansion(byte[] key) {
//        int Nk = key.length / 4;
//        int Nr = Nk + 6;
//        int Nb = 4;
//        byte[][] w = new byte[Nb * (Nr + 1)][];
//
//        for (int i = 0; i < Nk; i++) {
//            byte[] temp = new byte[]{key[4 * i], key[4 * i + 1], key[4 * i + 2], key[4 * i + 3]};
//            w[i] = temp;
//        }
//
//        for (int i = Nk; i < Nb * (Nr + 1); i++) {
//            byte[] temp = new byte[4];
//            System.arraycopy(w[i - 1], 0, temp, 0, 4);
//            if (i % Nk == 0) {
//                byte[] rotated = RotWord(temp);
//                byte[] subbed = SubWord(rotated);
//                byte rcon = Rcon[i / Nk];
//                subbed[0] ^= rcon;
//                temp = subbed;
//            } else if (Nk > 6 && i % Nk == 4) {
//                temp = SubWord(temp);
//            }
//            for (int j = 0; j < 4; j++) {
//                temp[j] ^= w[i - Nk][j];
//            }
//            w[i] = temp;
//        }
//
//        return w;
//    }
//
//    private static byte[] RotWord(byte[] word) {
//        byte temp = word[0];
//        System.arraycopy(word, 1, word, 0, 3);
//        word[3] = temp;
//        return word;
//    }
//
//    private static byte[] SubWord(byte[] word) {
//        byte[] result = new byte[4];
//        for (int i = 0; i < 4; i++) {
//            result[i] = SBox[word[i] & 0xFF];
//        }
//        return result;
//    }
//
//    private static final byte[] Rcon = {
//        0x00, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, (byte) 0x80, 0x1b, 0x36
//    };
//
//    // S-Box
//    private static final byte[] SBox = {
//        0x63, 0x7C, 0x77, 0x7B, (byte) 0xF2, 0x6B, 0x6F, (byte) 0xC5, 0x30, 0x01, 0x67, 0x2B, (byte) 0xFE, (byte) 0xD7, (byte) 0xAB, 0x76,
//        (byte) 0xCA, (byte) 0x82, (byte) 0xC9, 0x7D, (byte) 0xFA, 0x59, 0x47, (byte) 0xF0, (byte) 0xAD, (byte) 0xD4, (byte) 0xA2, (byte) 0xAF, (byte) 0x9C, (byte) 0xA4, 0x72, (byte) 0xC0,
//        (byte) 0xB7, (byte) 0xFD, (byte) 0x93, 0x26, 0x36, 0x3F, (byte) 0xF7, (byte) 0xCC, 0x34, (byte) 0xA5, (byte) 0xE5, (byte) 0xF1, 0x71, (byte) 0xD8, 0x31, 0x15,
//        0x04, (byte) 0xC7, 0x23, (byte) 0xC3, 0x18, (byte) 0x96, 0x05, (byte) 0x9A, 0x07, 0x12, (byte) 0x80, (byte) 0xE2, (byte) 0xEB, 0x27, (byte) 0xB2, 0x75,
//        0x09, (byte) 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A, (byte) 0xA0, 0x52, 0x3B, (byte) 0xD6, (byte) 0xB3, 0x29, (byte) 0xE3, 0x2F, (byte) 0x84,
//        0x53, (byte) 0xD1, 0x00, (byte) 0xED, 0x20, (byte) 0xFC, (byte) 0xB1, 0x5B, 0x6A, (byte) 0xCB, (byte) 0xBE, 0x39, 0x4A, 0x4C, 0x58, (byte) 0xCF,
//        (byte) 0xD0, (byte) 0xEF, (byte) 0xAA, (byte) 0xFB, 0x43, 0x4D, 0x33, (byte) 0x85, 0x45, (byte) 0xF9, 0x02, 0x7F, 0x50, 0x3C, (byte) 0x9F, (byte) 0xA8,
//        0x51, (byte) 0xA3, 0x40, (byte) 0x8F, (byte) 0x92, (byte) 0x9D, 0x38, (byte) 0xF5, (byte) 0xBC, (byte) 0xB6, (byte) 0xDA, 0x21, 0x10, (byte) 0xFF, (byte) 0xF3, (byte) 0xD2,
//        (byte) 0xCD, 0x0C, 0x13, (byte) 0xEC, 0x5F, (byte) 0x97, 0x44, 0x17, (byte) 0xC4, (byte) 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73,
//        0x60, (byte) 0x81, 0x4F, (byte) 0xDC, 0x22, 0x2A, (byte) 0x90, (byte) 0x88, 0x46, (byte) 0xEE, (byte) 0xB8, 0x14, (byte) 0xDE, 0x5E, 0x0B, (byte) 0xDB,
//        (byte) 0xE0, 0x32, 0x3A, 0x0A, 0x49, 0x06, 0x24, 0x5C, (byte) 0xC2, (byte) 0xD3, (byte) 0xAC, 0x62, (byte) 0x91, (byte) 0x95, (byte) 0xE4, 0x79,
//        (byte) 0xE7, (byte) 0xC8, 0x37, 0x6D, (byte) 0x8D, (byte) 0xD5, 0x4E, (byte) 0xA9, 0x6C, 0x56, (byte) 0xF4, (byte) 0xEA, 0x65, 0x7A, (byte) 0xAE, 0x08,
//        (byte) 0xBA, 0x78, 0x25, 0x2E, 0x1C, (byte) 0xA6, (byte) 0xB4, (byte) 0xC6, (byte) 0xE8, (byte) 0xDD, 0x74, 0x1F, 0x4B, (byte) 0xBD, (byte) 0x8B, (byte) 0x8A,
//        0x70, 0x3E, (byte) 0xB5, 0x66, 0x48, 0x03, (byte) 0xF6, 0x0E, 0x61, 0x35, 0x57, (byte) 0xB9, (byte) 0x86, (byte) 0xC1, 0x1D, (byte) 0x9E,
//        (byte) 0xE1, (byte) 0xF8, (byte) 0x98, 0x11, 0x69, (byte) 0xD9, (byte) 0x8E, (byte) 0x94, (byte) 0x9B, 0x1E, (byte) 0x87, (byte) 0xE9, (byte) 0xCE, 0x55, 0x28, (byte) 0xDF,
//        (byte) 0x8C, (byte) 0xA1, (byte) 0x89, 0x0D, (byte) 0xBF, (byte) 0xE6, 0x42, 0x68, 0x41, (byte) 0x99, 0x2D, 0x0F, (byte) 0xB0, 0x54, (byte) 0xBB, 0x16
//    };
//
//    // Inverse S-Box
//    private static final byte[] InvSBox = {
//        (byte) 0x52, (byte) 0x09, (byte) 0x6A, (byte) 0xD5, (byte) 0x30, (byte) 0x36, (byte) 0xA5, (byte) 0x38, (byte) 0xBF, (byte) 0x40, (byte) 0xA3, (byte) 0x9E, (byte) 0x81, (byte) 0xF3, (byte) 0xD7, (byte) 0xFB,
//        (byte) 0x7C, (byte) 0xE3, (byte) 0x39, (byte) 0x82, (byte) 0x9B, (byte) 0x2F, (byte) 0xFF, (byte) 0x87, (byte) 0x34, (byte) 0x8E, (byte) 0x43, (byte) 0x44, (byte) 0xC4, (byte) 0xDE, (byte) 0xE9, (byte) 0xCB,
//        (byte) 0x54, (byte) 0x7B, (byte) 0x94, (byte) 0x32, (byte) 0xA6, (byte) 0xC2, (byte) 0x23, (byte) 0x3D, (byte) 0xEE, (byte) 0x4C, (byte) 0x95, (byte) 0x0B, (byte) 0x42, (byte) 0xFA, (byte) 0xC3, (byte) 0x4E,
//        (byte) 0x08, (byte) 0x2E, (byte) 0xA1, (byte) 0x66, (byte) 0x28, (byte) 0xD9, (byte) 0x24, (byte) 0xB2, (byte) 0x76, (byte) 0x5B, (byte) 0xA2, (byte) 0x49, (byte) 0x6D, (byte) 0x8B, (byte) 0xD1, (byte) 0x25,
//        (byte) 0x72, (byte) 0xF8, (byte) 0xF6, (byte) 0x64, (byte) 0x86, (byte) 0x68, (byte) 0x98, (byte) 0x16, (byte) 0xD4, (byte) 0xA4, (byte) 0x5C, (byte) 0xCC, (byte) 0x5D, (byte) 0x65, (byte) 0xB6, (byte) 0x92,
//        (byte) 0x6C, (byte) 0x70, (byte) 0x48, (byte) 0x50, (byte) 0xFD, (byte) 0xED, (byte) 0xB9, (byte) 0xDA, (byte) 0x5E, (byte) 0x15, (byte) 0x46, (byte) 0x57, (byte) 0xA7, (byte) 0x8D, (byte) 0x9D, (byte) 0x84,
//        (byte) 0x90, (byte) 0xD8, (byte) 0xAB, (byte) 0x00, (byte) 0x8C, (byte) 0xBC, (byte) 0xD3, (byte) 0x0A, (byte) 0xF7, (byte) 0xE4, (byte) 0x58, (byte) 0x05, (byte) 0xB8, (byte) 0xB3, (byte) 0x45, (byte) 0x06,
//        (byte) 0xD0, (byte) 0x2C, (byte) 0x1E, (byte) 0x8F, (byte) 0xCA, (byte) 0x3F, (byte) 0x0F, (byte) 0x02, (byte) 0xC1, (byte) 0xAF, (byte) 0xBD, (byte) 0x03, (byte) 0x01, (byte) 0x13, (byte) 0x8A, (byte) 0x6B,
//        (byte) 0x3A, (byte) 0x91, (byte) 0x11, (byte) 0x41, (byte) 0x4F, (byte) 0x67, (byte) 0xDC, (byte) 0xEA, (byte) 0x97, (byte) 0xF2, (byte) 0xCF, (byte) 0xCE, (byte) 0xF0, (byte) 0xB4, (byte) 0xE6, (byte) 0x73,
//        (byte) 0x96, (byte) 0xAC, (byte) 0x74, (byte) 0x22, (byte) 0xE7, (byte) 0xAD, (byte) 0x35, (byte) 0x85, (byte) 0xE2, (byte) 0xF9, (byte) 0x37, (byte) 0xE8, (byte) 0x1C, (byte) 0x75, (byte) 0xDF, (byte) 0x6E,
//        (byte) 0x47, (byte) 0xF1, (byte) 0x1A, (byte) 0x71, (byte) 0x1D, (byte) 0x29, (byte) 0xC5, (byte) 0x89, (byte) 0x6F, (byte) 0xB7, (byte) 0x62, (byte) 0x0E, (byte) 0xAA, (byte) 0x18, (byte) 0xBE, (byte) 0x1B,
//        (byte) 0xFC, (byte) 0x56, (byte) 0x3E, (byte) 0x4B, (byte) 0xC6, (byte) 0xD2, (byte) 0x79, (byte) 0x20, (byte) 0x9A, (byte) 0xDB, (byte) 0xC0, (byte) 0xFE, (byte) 0x78, (byte) 0xCD, (byte) 0x5A, (byte) 0xF4,
//        (byte) 0x1F, (byte) 0xDD, (byte) 0xA8, (byte) 0x33, (byte) 0x88, (byte) 0x07, (byte) 0xC7, (byte) 0x31, (byte) 0xB1, (byte) 0x12, (byte) 0x10, (byte) 0x59, (byte) 0x27, (byte) 0x80, (byte) 0xEC, (byte) 0x5F,
//        (byte) 0x60, (byte) 0x51, (byte) 0x7F, (byte) 0xA9, (byte) 0x19, (byte) 0xB5, (byte) 0x4A, (byte) 0x0D, (byte) 0x2D, (byte) 0xE5, (byte) 0x7A, (byte) 0x9F, (byte) 0x93, (byte) 0xC9, (byte) 0x9C, (byte) 0xEF,
//        (byte) 0xA0, (byte) 0xE0, (byte) 0x3B, (byte) 0x4D, (byte) 0xAE, (byte) 0x2A, (byte) 0xF5, (byte) 0xB0, (byte) 0xC8, (byte) 0xEB, (byte) 0xBB, (byte) 0x3C, (byte) 0x83, (byte) 0x53, (byte) 0x99, (byte) 0x61,
//        (byte) 0x17, (byte) 0x2B, (byte) 0x04, (byte) 0x7E, (byte) 0xBA, (byte) 0x77, (byte) 0xD6, (byte) 0x26, (byte) 0xE1, (byte) 0x69, (byte) 0x14, (byte) 0x63, (byte) 0x55, (byte) 0x21, (byte) 0x0C, (byte) 0x7D
//    };
//}
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AES {
    private static final int BlockSize = 16;

    public static byte[] encrypt(String plainText, String key) {
        byte[] plainBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

        return encryptFullText(plainBytes, keyBytes);
    }

    public static String decrypt(byte[] cipherText, String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

        byte[] decryptedBytes = decryptFullText(cipherText, keyBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static byte[] encryptFullText(byte[] plainText, byte[] key) {
        List<Byte> cipherBytes = new ArrayList<>();

        for (int i = 0; i < plainText.length; i += BlockSize) {
            byte[] chunk = new byte[BlockSize];
            System.arraycopy(plainText, i, chunk, 0, Math.min(BlockSize, plainText.length - i));
            byte[] encryptedChunk = encryptChunk(chunk, key);
            for (byte b : encryptedChunk) {
                cipherBytes.add(b);
            }
        }

        byte[] result = new byte[cipherBytes.size()];
        for (int i = 0; i < cipherBytes.size(); i++) {
            result[i] = cipherBytes.get(i);
        }
        return result;
    }

    private static byte[] encryptChunk(byte[] plainBytes, byte[] keyBytes) {
        byte[][] state = new byte[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = plainBytes[i + 4 * j];
            }
        }

        byte[][] w = keyExpansion(keyBytes);

        addRoundKey(state, w, 0);

        for (int round = 1; round < 10; round++) {
            subBytes(state);
            shiftRows(state);
            mixColumns(state);
            addRoundKey(state, w, round);
        }

        subBytes(state);
        shiftRows(state);
        addRoundKey(state, w, 10);

        byte[] cipherBytes = new byte[BlockSize];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cipherBytes[i + 4 * j] = state[i][j];
            }
        }

        return cipherBytes;
    }

    private static byte[] decryptChunk(byte[] cipherBytes, byte[] keyBytes) {
        byte[][] state = new byte[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = cipherBytes[i + 4 * j];
            }
        }

        byte[][] w = keyExpansion(keyBytes);

        addRoundKey(state, w, 10);

        for (int round = 9; round > 0; round--) {
            invShiftRows(state);
            invSubBytes(state);
            addRoundKey(state, w, round);
            invMixColumns(state);
        }

        invShiftRows(state);
        invSubBytes(state);
        addRoundKey(state, w, 0);

        byte[] plainBytes = new byte[BlockSize];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                plainBytes[i + 4 * j] = state[i][j];
            }
        }

        return plainBytes;
    }

    public static byte[] decryptFullText(byte[] cipherText, byte[] key) {
        List<Byte> decryptedBytes = new ArrayList<>();

        for (int i = 0; i < cipherText.length; i += BlockSize) {
            byte[] chunk = new byte[BlockSize];
            System.arraycopy(cipherText, i, chunk, 0, Math.min(BlockSize, cipherText.length - i));
            byte[] decryptedChunk = decryptChunk(chunk, key);
            for (byte b : decryptedChunk) {
                decryptedBytes.add(b);
            }
        }

        byte[] result = new byte[decryptedBytes.size()];
        for (int i = 0; i < decryptedBytes.size(); i++) {
            result[i] = decryptedBytes.get(i);
        }
        return result;
    }

    private static void subBytes(byte[][] state) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = SBox[state[i][j] & 0xFF];
            }
        }
    }

    private static void invSubBytes(byte[][] state) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = InvSBox[state[i][j] & 0xFF];
            }
        }
    }

    private static void shiftRows(byte[][] state) {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                byte temp = state[i][0];
                for (int k = 0; k < 3; k++) {
                    state[i][k] = state[i][k + 1];
                }
                state[i][3] = temp;
            }
        }
    }

    private static void invShiftRows(byte[][] state) {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                byte temp = state[i][3];
                for (int k = 3; k > 0; k--) {
                    state[i][k] = state[i][k - 1];
                }
                state[i][0] = temp;
            }
        }
    }

    private static void mixColumns(byte[][] state) {
        byte[][] temp = new byte[4][4];

        for (int c = 0; c < 4; c++) {
            temp[0][c] = (byte)(multiply(0x02, state[0][c]) ^ multiply(0x03, state[1][c]) ^ state[2][c] ^ state[3][c]);
            temp[1][c] = (byte)(state[0][c] ^ multiply(0x02, state[1][c]) ^ multiply(0x03, state[2][c]) ^ state[3][c]);
            temp[2][c] = (byte)(state[0][c] ^ state[1][c] ^ multiply(0x02, state[2][c]) ^ multiply(0x03, state[3][c]));
            temp[3][c] = (byte)(multiply(0x03, state[0][c]) ^ state[1][c] ^ state[2][c] ^ multiply(0x02, state[3][c]));
        }

        for (int i = 0; i < 4; i++) {
            System.arraycopy(temp[i], 0, state[i], 0, 4);
        }
    }

    private static void invMixColumns(byte[][] state) {
        byte[][] temp = new byte[4][4];

        for (int c = 0; c < 4; c++) {
            temp[0][c] = (byte)(multiply(0x0e, state[0][c]) ^ multiply(0x0b, state[1][c]) ^ multiply(0x0d, state[2][c]) ^ multiply(0x09, state[3][c]));
            temp[1][c] = (byte)(multiply(0x09, state[0][c]) ^ multiply(0x0e, state[1][c]) ^ multiply(0x0b, state[2][c]) ^ multiply(0x0d, state[3][c]));
            temp[2][c] = (byte)(multiply(0x0d, state[0][c]) ^ multiply(0x09, state[1][c]) ^ multiply(0x0e, state[2][c]) ^ multiply(0x0b, state[3][c]));
            temp[3][c] = (byte)(multiply(0x0b, state[0][c]) ^ multiply(0x0d, state[1][c]) ^ multiply(0x09, state[2][c]) ^ multiply(0x0e, state[3][c]));
        }

        for (int i = 0; i < 4; i++) {
            System.arraycopy(temp[i], 0, state[i], 0, 4);
        }
    }

    private static void addRoundKey(byte[][] state, byte[][] w, int round) {
        for (int c = 0; c < 4; c++) {
            for (int r = 0; r < 4; r++) {
                state[r][c] ^= w[4 * round + c][r];
            }
        }
    }

    private static byte[][] keyExpansion(byte[] key) {
        byte[][] w = new byte[44][4];

        for (int i = 0; i < 16; i++) {
            w[i / 4][i % 4] = key[i];
        }

        for (int i = 4; i < 44; i++) {
            byte[] temp = new byte[4];
            System.arraycopy(w[i - 1], 0, temp, 0, 4);
            if (i % 4 == 0) {
                byte[] rotated = rotateWord(temp);
                for (int j = 0; j < 4; j++) {
                    rotated[j] = SBox[rotated[j] & 0xFF];
                }
                rotated[0] ^= RCon[i / 4];
                for (int j = 0; j < 4; j++) {
                    temp[j] ^= rotated[j];
                }
            }
            for (int j = 0; j < 4; j++) {
                w[i][j] = (byte)(w[i - 4][j] ^ temp[j]);
            }
        }

        return w;
    }

    private static byte[] rotateWord(byte[] word) {
        byte[] result = new byte[word.length];
        System.arraycopy(word, 1, result, 0, word.length - 1);
        result[word.length - 1] = word[0];
        return result;
    }

    private static int multiply(int a, int b) {
        int p = 0;
        for (int i = 0; i < 8; i++) {
            if ((b & 1) != 0) {
                p ^= a;
            }
            boolean hiBitSet = (a & 0x80) != 0;
            a <<= 1;
            if (hiBitSet) {
                a ^= 0x1b;
            }
            b >>= 1;
        }
        return p & 0xFF;
    }
    private static final byte[] RCon = {
    		 (byte) 0x8d, (byte) 0x01, (byte) 0x02, (byte) 0x04, (byte) 0x08, (byte) 0x10, (byte) 0x20, (byte) 0x40, 
             (byte) 0x80, (byte) 0x1b, (byte) 0x36, (byte) 0x6c, (byte) 0xd8, (byte) 0xab, (byte) 0x4d, (byte) 0x9a,
             (byte) 0x2f, (byte) 0x5e, (byte) 0xbc, (byte) 0x63, (byte) 0xc6, (byte) 0x97, (byte) 0x35, (byte) 0x6a, 
             (byte) 0xd4, (byte) 0xb3, (byte) 0x7d, (byte) 0xfa, (byte) 0xef, (byte) 0xc5, (byte) 0x91, (byte) 0x39,
             (byte) 0x72, (byte) 0xe4, (byte) 0xd3, (byte) 0xbd, (byte) 0x61, (byte) 0xc2, (byte) 0x9f, (byte) 0x25,
             (byte) 0x4a, (byte) 0x94, (byte) 0x33, (byte) 0x66, (byte) 0xcc, (byte) 0x83, (byte) 0x1d, (byte) 0x3a,
             (byte) 0x74, (byte) 0xe8, (byte) 0xcb, (byte) 0x8d, (byte) 0x01, (byte) 0x02, (byte) 0x04, (byte) 0x08,
             (byte) 0x10, (byte) 0x20, (byte) 0x40, (byte) 0x80, (byte) 0x1b, (byte) 0x36, (byte) 0x6c, (byte) 0xd8,
             (byte) 0xab, (byte) 0x4d, (byte) 0x9a, (byte) 0x2f, (byte) 0x5e, (byte) 0xbc, (byte) 0x63, (byte) 0xc6,
             (byte) 0x97, (byte) 0x35, (byte) 0x6a, (byte) 0xd4, (byte) 0xb3, (byte) 0x7d, (byte) 0xfa, (byte) 0xef,
             (byte) 0xc5, (byte) 0x91, (byte) 0x39, (byte) 0x72, (byte) 0xe4, (byte) 0xd3, (byte) 0xbd, (byte) 0x61,
             (byte) 0xc2, (byte) 0x9f, (byte) 0x25, (byte) 0x4a, (byte) 0x94, (byte) 0x33, (byte) 0x66, (byte) 0xcc,
             (byte) 0x83, (byte) 0x1d, (byte) 0x3a, (byte) 0x74, (byte) 0xe8, (byte) 0xcb, (byte) 0x8d, (byte) 0x01,
             (byte) 0x02, (byte) 0x04, (byte) 0x08, (byte) 0x10, (byte) 0x20, (byte) 0x40, (byte) 0x80, (byte) 0x1b,
             (byte) 0x36, (byte) 0x6c, (byte) 0xd8, (byte) 0xab, (byte) 0x4d, (byte) 0x9a, (byte) 0x2f, (byte) 0x5e,
             (byte) 0xbc, (byte) 0x63, (byte) 0xc6, (byte) 0x97, (byte) 0x35, (byte) 0x6a, (byte) 0xd4, (byte) 0xb3,
             (byte) 0x7d, (byte) 0xfa, (byte) 0xef, (byte) 0xc5, (byte) 0x91, (byte) 0x39, (byte) 0x72, (byte) 0xe4,
             (byte) 0xd3, (byte) 0xbd, (byte) 0x61, (byte) 0xc2, (byte) 0x9f, (byte) 0x25, (byte) 0x4a, (byte) 0x94,
             (byte) 0x33, (byte) 0x66, (byte) 0xcc, (byte) 0x83, (byte) 0x1d, (byte) 0x3a, (byte) 0x74, (byte) 0xe8,
             (byte) 0xcb, (byte) 0x8d, (byte) 0x01, (byte) 0x02, (byte) 0x04, (byte) 0x08, (byte) 0x10, (byte) 0x20,
             (byte) 0x40, (byte) 0x80, (byte) 0x1b, (byte) 0x36, (byte) 0x6c, (byte) 0xd8, (byte) 0xab, (byte) 0x4d,
             (byte) 0x9a, (byte) 0x2f, (byte) 0x5e, (byte) 0xbc, (byte) 0x63, (byte) 0xc6, (byte) 0x97, (byte) 0x35,
             (byte) 0x6a, (byte) 0xd4, (byte) 0xb3, (byte) 0x7d, (byte) 0xfa, (byte) 0xef, (byte) 0xc5, (byte) 0x91,
             (byte) 0x39, (byte) 0x72, (byte) 0xe4, (byte) 0xd3, (byte) 0xbd, (byte) 0x61, (byte) 0xc2, (byte) 0x9f,
             (byte) 0x25, (byte) 0x4a, (byte) 0x94, (byte) 0x33, (byte) 0x66, (byte) 0xcc, (byte) 0x83, (byte) 0x1d,
             (byte) 0x3a, (byte) 0x74, (byte) 0xe8, (byte) 0xcb, (byte) 0x8d };
    private static final byte[] SBox = {
            (byte) 0x63, (byte) 0x7c, (byte) 0x77, (byte) 0x7b, (byte) 0xf2, (byte) 0x6b, (byte) 0x6f, (byte) 0xc5, (byte) 0x30, (byte) 0x01, (byte) 0x67, (byte) 0x2b, (byte) 0xfe, (byte) 0xd7, (byte) 0xab, (byte) 0x76,
            (byte) 0xca, (byte) 0x82, (byte) 0xc9, (byte) 0x7d, (byte) 0xfa, (byte) 0x59, (byte) 0x47, (byte) 0xf0, (byte) 0xad, (byte) 0xd4, (byte) 0xa2, (byte) 0xaf, (byte) 0x9c, (byte) 0xa4, (byte) 0x72, (byte) 0xc0,
            (byte) 0xb7, (byte) 0xfd, (byte) 0x93, (byte) 0x26, (byte) 0x36, (byte) 0x3f, (byte) 0xf7, (byte) 0xcc, (byte) 0x34, (byte) 0xa5, (byte) 0xe5, (byte) 0xf1, (byte) 0x71, (byte) 0xd8, (byte) 0x31, (byte) 0x15,
            (byte) 0x04, (byte) 0xc7, (byte) 0x23, (byte) 0xc3, (byte) 0x18, (byte) 0x96, (byte) 0x05, (byte) 0x9a, (byte) 0x07, (byte) 0x12, (byte) 0x80, (byte) 0xe2, (byte) 0xeb, (byte) 0x27, (byte) 0xb2, (byte) 0x75,
            (byte) 0x09, (byte) 0x83, (byte) 0x2c, (byte) 0x1a, (byte) 0x1b, (byte) 0x6e, (byte) 0x5a, (byte) 0xa0, (byte) 0x52, (byte) 0x3b, (byte) 0xd6, (byte) 0xb3, (byte) 0x29, (byte) 0xe3, (byte) 0x2f, (byte) 0x84,
            (byte) 0x53, (byte) 0xd1, (byte) 0x00, (byte) 0xed, (byte) 0x20, (byte) 0xfc, (byte) 0xb1, (byte) 0x5b, (byte) 0x6a, (byte) 0xcb, (byte) 0xbe, (byte) 0x39, (byte) 0x4a, (byte) 0x4c, (byte) 0x58, (byte) 0xcf,
            (byte) 0xd0, (byte) 0xef, (byte) 0xaa, (byte) 0xfb, (byte) 0x43, (byte) 0x4d, (byte) 0x33, (byte) 0x85, (byte) 0x45, (byte) 0xf9, (byte) 0x02, (byte) 0x7f, (byte) 0x50, (byte) 0x3c, (byte) 0x9f, (byte) 0xa8,
            (byte) 0x51, (byte) 0xa3, (byte) 0x40, (byte) 0x8f, (byte) 0x92, (byte) 0x9d, (byte) 0x38, (byte) 0xf5, (byte) 0xbc, (byte) 0xb6, (byte) 0xda, (byte) 0x21, (byte) 0x10, (byte) 0xff, (byte) 0xf3, (byte) 0xd2,
            (byte) 0xcd, (byte) 0x0c, (byte) 0x13, (byte) 0xec, (byte) 0x5f, (byte) 0x97, (byte) 0x44, (byte) 0x17, (byte) 0xc4, (byte) 0xa7, (byte) 0x7e, (byte) 0x3d, (byte) 0x64, (byte) 0x5d, (byte) 0x19, (byte) 0x73,
            (byte) 0x60, (byte) 0x81, (byte) 0x4f, (byte) 0xdc, (byte) 0x22, (byte) 0x2a, (byte) 0x90, (byte) 0x88, (byte) 0x46, (byte) 0xee, (byte) 0xb8, (byte) 0x14, (byte) 0xde, (byte) 0x5e, (byte) 0x0b, (byte) 0xdb,
            (byte) 0xe0, (byte) 0x32, (byte) 0x3a, (byte) 0x0a, (byte) 0x49, (byte) 0x06, (byte) 0x24, (byte) 0x5c, (byte) 0xc2, (byte) 0xd3, (byte) 0xac, (byte) 0x62, (byte) 0x91, (byte) 0x95, (byte) 0xe4, (byte) 0x79,
            (byte) 0xe7, (byte) 0xc8, (byte) 0x37, (byte) 0x6d, (byte) 0x8d, (byte) 0xd5, (byte) 0x4e, (byte) 0xa9, (byte) 0x6c, (byte) 0x56, (byte) 0xf4, (byte) 0xea, (byte) 0x65, (byte) 0x7a, (byte) 0xae, (byte) 0x08,
            (byte) 0xba, (byte) 0x78, (byte) 0x25, (byte) 0x2e, (byte) 0x1c, (byte) 0xa6, (byte) 0xb4, (byte) 0xc6, (byte) 0xe8, (byte) 0xdd, (byte) 0x74, (byte) 0x1f, (byte) 0x4b, (byte) 0xbd, (byte) 0x8b, (byte) 0x8a,
            (byte) 0x70, (byte) 0x3e, (byte) 0xb5, (byte) 0x66, (byte) 0x48, (byte) 0x03, (byte) 0xf6, (byte) 0x0e, (byte) 0x61, (byte) 0x35, (byte) 0x57, (byte) 0xb9, (byte) 0x86, (byte) 0xc1, (byte) 0x1d, (byte) 0x9e,
            (byte) 0xe1, (byte) 0xf8, (byte) 0x98, (byte) 0x11, (byte) 0x69, (byte) 0xd9, (byte) 0x8e, (byte) 0x94, (byte) 0x9b, (byte) 0x1e, (byte) 0x87, (byte) 0xe9, (byte) 0xce, (byte) 0x55, (byte) 0x28, (byte) 0xdf,
            (byte) 0x8c, (byte) 0xa1, (byte) 0x89, (byte) 0x0d, (byte) 0xbf, (byte) 0xe6, (byte) 0x42, (byte) 0x68, (byte) 0x41, (byte) 0x99, (byte) 0x2d, (byte) 0x0f, (byte) 0xb0, (byte) 0x54, (byte) 0xbb, (byte) 0x16};

    private static final byte[] InvSBox = {
            (byte) 0x52, (byte) 0x09, (byte) 0x6a, (byte) 0xd5, (byte) 0x30, (byte) 0x36, (byte) 0xa5, (byte) 0x38, (byte) 0xbf, (byte) 0x40, (byte) 0xa3, (byte) 0x9e, (byte) 0x81, (byte) 0xf3, (byte) 0xd7, (byte) 0xfb,
            (byte) 0x7c, (byte) 0xe3, (byte) 0x39, (byte) 0x82, (byte) 0x9b, (byte) 0x2f, (byte) 0xff, (byte) 0x87, (byte) 0x34, (byte) 0x8e, (byte) 0x43, (byte) 0x44, (byte) 0xc4, (byte) 0xde, (byte) 0xe9, (byte) 0xcb,
            (byte) 0x54, (byte) 0x7b, (byte) 0x94, (byte) 0x32, (byte) 0xa6, (byte) 0xc2, (byte) 0x23, (byte) 0x3d, (byte) 0xee, (byte) 0x4c, (byte) 0x95, (byte) 0x0b, (byte) 0x42, (byte) 0xfa, (byte) 0xc3, (byte) 0x4e,
            (byte) 0x08, (byte) 0x2e, (byte) 0xa1, (byte) 0x66, (byte) 0x28, (byte) 0xd9, (byte) 0x24, (byte) 0xb2, (byte) 0x76, (byte) 0x5b, (byte) 0xa2, (byte) 0x49, (byte) 0x6d, (byte) 0x8b, (byte) 0xd1, (byte) 0x25,
            (byte) 0x72, (byte) 0xf8, (byte) 0xf6, (byte) 0x64, (byte) 0x86, (byte) 0x68, (byte) 0x98, (byte) 0x16, (byte) 0xd4, (byte) 0xa4, (byte) 0x5c, (byte) 0xcc, (byte) 0x5d, (byte) 0x65, (byte) 0xb6, (byte) 0x92,
            (byte) 0x6c, (byte) 0x70, (byte) 0x48, (byte) 0x50, (byte) 0xfd, (byte) 0xed, (byte) 0xb9, (byte) 0xda, (byte) 0x5e, (byte) 0x15, (byte) 0x46, (byte) 0x57, (byte) 0xa7, (byte) 0x8d, (byte) 0x9d, (byte) 0x84,
            (byte) 0x90, (byte) 0xd8, (byte) 0xab, (byte) 0x00, (byte) 0x8c, (byte) 0xbc, (byte) 0xd3, (byte) 0x0a, (byte) 0xf7, (byte) 0xe4, (byte) 0x58, (byte) 0x05, (byte) 0xb8, (byte) 0xb3, (byte) 0x45, (byte) 0x06,
            (byte) 0xd0, (byte) 0x2c, (byte) 0x1e, (byte) 0x8f, (byte) 0xca, (byte) 0x3f, (byte) 0x0f, (byte) 0x02, (byte) 0xc1, (byte) 0xaf, (byte) 0xbd, (byte) 0x03, (byte) 0x01, (byte) 0x13, (byte) 0x8a, (byte) 0x6b,
            (byte) 0x3a, (byte) 0x91, (byte) 0x11, (byte) 0x41, (byte) 0x4f, (byte) 0x67, (byte) 0xdc, (byte) 0xea, (byte) 0x97, (byte) 0xf2, (byte) 0xcf, (byte) 0xce, (byte) 0xf0, (byte) 0xb4, (byte) 0xe6, (byte) 0x73,
            (byte) 0x96, (byte) 0xac, (byte) 0x74, (byte) 0x22, (byte) 0xe7, (byte) 0xad, (byte) 0x35, (byte) 0x85, (byte) 0xe2, (byte) 0xf9, (byte) 0x37, (byte) 0xe8, (byte) 0x1c, (byte) 0x75, (byte) 0xdf, (byte) 0x6e,
            (byte) 0x47, (byte) 0xf1, (byte) 0x1a, (byte) 0x71, (byte) 0x1d, (byte) 0x29, (byte) 0xc5, (byte) 0x89, (byte) 0x6f, (byte) 0xb7, (byte) 0x62, (byte) 0x0e, (byte) 0xaa, (byte) 0x18, (byte) 0xbe, (byte) 0x1b,
            (byte) 0xfc, (byte) 0x56, (byte) 0x3e, (byte) 0x4b, (byte) 0xc6, (byte) 0xd2, (byte) 0x79, (byte) 0x20, (byte) 0x9a, (byte) 0xdb, (byte) 0xc0, (byte) 0xfe, (byte) 0x78, (byte) 0xcd, (byte) 0x5a, (byte) 0xf4,
            (byte) 0x1f, (byte) 0xdd, (byte) 0xa8, (byte) 0x33, (byte) 0x88, (byte) 0x07, (byte) 0xc7, (byte) 0x31, (byte) 0xb1, (byte) 0x12, (byte) 0x10, (byte) 0x59, (byte) 0x27, (byte) 0x80, (byte) 0xec, (byte) 0x5f,
            (byte) 0x60, (byte) 0x51, (byte) 0x7f, (byte) 0xa9, (byte) 0x19, (byte) 0xb5, (byte) 0x4a, (byte) 0x0d, (byte) 0x2d, (byte) 0xe5, (byte) 0x7a, (byte) 0x9f, (byte) 0x93, (byte) 0xc9, (byte) 0x9c, (byte) 0xef,
            (byte) 0xa0, (byte) 0xe0, (byte) 0x3b, (byte) 0x4d, (byte) 0xae, (byte) 0x2a, (byte) 0xf5, (byte) 0xb0, (byte) 0xc8, (byte) 0xeb, (byte) 0xbb, (byte) 0x3c, (byte) 0x83, (byte) 0x53, (byte) 0x99, (byte) 0x61,
            (byte) 0x17, (byte) 0x2b, (byte) 0x04, (byte) 0x7e, (byte) 0xba, (byte) 0x77, (byte) 0xd6, (byte) 0x26, (byte) 0xe1, (byte) 0x69, (byte) 0x14, (byte) 0x63, (byte) 0x55, (byte) 0x21, (byte) 0x0c, (byte) 0x7d};
    
}

