package edu.nicolasQuintero.matrixWeb;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@CrossOrigin(origins="*")
@RestController
public class MatrixController {
    @PostMapping("/addition")
    public int [][] addition(@RequestBody TwoMatrixRequest request) throws InvalidMatrixException{
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix a = new Matrix (request.getMatrixA());
        Matrix b = new Matrix (request.getMatrixB());
        return mw.matrixAddition(a,b).getData();
    }

    @PostMapping("/substraction")
    public int [][] substraction(@RequestBody TwoMatrixRequest request) throws InvalidMatrixException{
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix a = new Matrix (request.getMatrixA());
        Matrix b = new Matrix (request.getMatrixB());
        return mw.matrixSubstraction(a,b).getData();
    }

    @PostMapping("/multiplication")
    public int [][] multiplication(@RequestBody TwoMatrixRequest request) throws InvalidMatrixException{
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix a = new Matrix (request.getMatrixA());
        Matrix b = new Matrix (request.getMatrixB());
        return mw.matrixMultiplication(a,b).getData();
    }

    @PostMapping("/importCSV")
    public int [][] importCSV(@RequestParam("file")MultipartFile file) throws InvalidMatrixException, Exception{
        if (file.isEmpty()){
            throw new InvalidMatrixException("No file selected.");
        }
        File tempFile = File.createTempFile("matrix",".csv");
        file.transferTo(tempFile);
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix matrix = mw.importCSV(tempFile.getAbsolutePath());
        return matrix.getData();
    }
}
