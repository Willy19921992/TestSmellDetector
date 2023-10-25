package testsmell;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

/**
 * This class is utilized to write output to a HTML file
 */
public class ResultsWriter {

    private String outputFile;
    private FileWriter writer;

    /**
     * Creates the file into which output it to be written into. Results from each file will be stored in a new file
     * @throws IOException
     */
    private ResultsWriter() throws IOException {
        String time =  String.valueOf(Calendar.getInstance().getTimeInMillis());
        outputFile = MessageFormat.format("{0}_{1}_{2}.{3}", "Output","TestSmellDetection",time, "html");
        writer = new FileWriter(outputFile,false);
    }

    /**
     * Factory method that provides a new instance of the ResultsWriter
     * @return new ResultsWriter instance
     * @throws IOException
     */
    public static ResultsWriter createResultsWriter() throws IOException {
        return new ResultsWriter();
    }

    /**
     * Writes column names into the HTML file
     * @param columnNames the column names
     * @throws IOException
     */
    public void writeColumnName(List<String> columnNames) throws IOException {
        writer = new FileWriter(outputFile,true);
        
        writer.append("<!DOCTYPE html><html><body><table><tr>");
        for(int i = 0; i < columnNames.size(); i++)
            writer.append("<th>" + columnNames.get(i) + "</th>");
        writer.append("</tr>");
        
        writer.flush();
        writer.close();
    }

    /**
     * Writes column values into the HTML file
     * @param columnValues the column values
     * @throws IOException
     */
    public void writeLine(List<String> columnValues) throws IOException {
        writer = new FileWriter(outputFile,true);
        
        writer.append("<tr>");
        for(int i = 0; i < columnValues.size(); i++)
            writer.append("<td>" + columnValues.get(i) + "</td>");
        writer.append("</tr>");
        
        writer.flush();
        writer.close();
    }
    
    /**
     * Writes footer into the HTML file
     * @throws IOException
     */
    public void writeFooter() throws IOException {
        writer = new FileWriter(outputFile,true);
        
        writer.append("</table></body></html>");
        
        writer.flush();
        writer.close();
    }
}
