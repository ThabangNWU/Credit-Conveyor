package com.thabang.conveyor;

import com.thabang.conveyor.dto.LoanApplicationRequestDTO;
import com.thabang.conveyor.dto.LoanOfferDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ConveyorService {
   private LoanApplicationRequestDTO loanApplicationRequestDTO = new LoanApplicationRequestDTO();
    public void registerClient(ConveyorRegistrationRequested request) {
//
     /*
     private BigDecimal amount;
    private Integer term;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private LocalDate birthDate;
    private String passportSeries;
    private String passportNumber;*/

    }


    public List<LoanApplicationRequestDTO> getUserInfo(){

        return (List<LoanApplicationRequestDTO>) clientsDetails();
    }

    private LoanApplicationRequestDTO clientsDetails()
    {
        Conveyor conveyor = new Conveyor();

        loanApplicationRequestDTO.setAmount(conveyor.getAmount());
        loanApplicationRequestDTO.setTerm(conveyor.getTerm());
        loanApplicationRequestDTO.setFirstName(conveyor.getFirstName());
        loanApplicationRequestDTO.setLastName(conveyor.getLastName());
        loanApplicationRequestDTO.setMiddleName(conveyor.getMiddleName());
        loanApplicationRequestDTO.setEmail(conveyor.getEmail());
        loanApplicationRequestDTO.setBirthDate(conveyor.getBirthDate());
        loanApplicationRequestDTO.setPassportSeries(conveyor.getPassportSeries());
        loanApplicationRequestDTO.setPassportNumber(conveyor.getPassportNumber());;
        validateUser();
        validateEmail(conveyor.getEmail());

        return loanApplicationRequestDTO;
    }

    public void validateUser()
    {
        Pattern pattern = Pattern.compile("[\\p{L}&&[^\\x{0d000}-\\x{10ffff}{2,30}]]+");
        pattern.matcher(loanApplicationRequestDTO.getFirstName());
        pattern.matcher(loanApplicationRequestDTO.getMiddleName());
        pattern.matcher(loanApplicationRequestDTO.getLastName());
        Pattern pattern1 = Pattern.compile("^[0-9]{4}");
        pattern1.matcher(loanApplicationRequestDTO.getPassportSeries());
        Pattern pattern2 = Pattern.compile("^[0-9]{6}");
        pattern1.matcher(loanApplicationRequestDTO.getPassportNumber());


    }

    public String calculateAge()
    {
        String strTime = loanApplicationRequestDTO.getBirthDate().format(DateTimeFormatter.ISO_DATE);
        LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
        LocalDate currentDate = LocalDate.now();
        final BigDecimal amount = BigDecimal.valueOf(10000);
        int age = Period.between(loanApplicationRequestDTO.getBirthDate(),currentDate).getYears();
        if( age >= 18)
        {
            if(loanApplicationRequestDTO.getAmount().compareTo(amount) >= 10000)
            {
                if(loanOfferDTO.getInsuranceEnabled() == false && loanOfferDTO.getSalaryClient() == false)
                {

                }
                else if(loanOfferDTO.getInsuranceEnabled() == true && loanOfferDTO.getSalaryClient() == false)
                {

                }
                else if(loanOfferDTO.getInsuranceEnabled() == false && loanOfferDTO.getSalaryClient() == true)
                {

                }
                else
                {

                }

            }
        }
        return strTime;

    }
    String emailStr = loanApplicationRequestDTO.getEmail();
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("/^(w[+.w]{2,50})*@([w-]+.)*([a-z]{2,20}|d+)$i",Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr)
    {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

}
