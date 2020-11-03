package org.kevinzuhoski.japaneserestaurant.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.Inquiry;
import org.kevinzuhoski.japaneserestaurant.models.InquiryReason;
import org.kevinzuhoski.japaneserestaurant.models.dto.InquiryDTO;
import org.kevinzuhoski.japaneserestaurant.models.dto.InquiryReasonDTO;
import org.kevinzuhoski.japaneserestaurant.repositories.CustomerRepository;
import org.kevinzuhoski.japaneserestaurant.repositories.InquiryReasonRepository;
import org.kevinzuhoski.japaneserestaurant.repositories.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImplementation implements ContactService {
	
	private InquiryRepository inquiryRepository;
	
	private InquiryReasonRepository inquiryReasonRepository;
	
	private CustomerRepository customerRepository;
	
	// Injecting the inqiryReasonRepository, customerRepository, and inquiryRepository into
	// the ContactServiceImplementation using constructor injection
	
	@Autowired
	public void ContactServiceImplementation(InquiryReasonRepository inquiryReasonRepository,
			CustomerRepository customerRepository, InquiryRepository inquiryRepository) {
		this.inquiryReasonRepository = inquiryReasonRepository;
		this.customerRepository = customerRepository;
		this.inquiryRepository = inquiryRepository;
	}
	
	// Method to create an inquiry.  A new inquiry object is created and the inquiryDTO information is 
	// passed into that object using getters/setters.  A date is also set for the inquiry.  We then find the
	// customer who wrote the inquiry using a method from the customerRepository.  If the customerFound List has
	// a size greater than zero, meaning the customer was found, the id of the customer object is set to the id
	// of the customer found.  Else the customers firstName, lastName, and phoneNumber is set to that of the
	// customerDTO.  The properties of the inquiry are then set and the inquiry is saved.  

	@Override
	public boolean createInquiry(InquiryDTO inquiryDTO) {
		
		Inquiry inquiry = new Inquiry();
		inquiry.setInquiryInformation(inquiryDTO.getInquiryInformation());
		inquiry.setVisitHistory(inquiryDTO.getVisitHistory());
		inquiry.setContactDays(String.join(",", inquiryDTO.getContactDays()));
		
		inquiry.setInquiryDate(new Date());
		
		List<Customer> customerFound = customerRepository.findCustomerByFirstNameAndLastName(
				inquiryDTO.getCustomer().getFirstName(), inquiryDTO.getCustomer().getLastName());
		
		Customer customerFull = new Customer();
		
		if(customerFound.size()>0) {
			customerFull.setCustomerId(customerFound.get(0).getCustomerId());
		}else {
			Customer customer = new Customer();
			customer.setCustomerId(0);
			customer.setFirstName(inquiryDTO.getCustomer().getFirstName());
			customer.setLastName(inquiryDTO.getCustomer().getLastName());
			customer.setPhoneNumber(inquiryDTO.getCustomer().getPhoneNumber());
			customer.setAddress(inquiryDTO.getCustomer().getAddress());
			customer.setEmail(inquiryDTO.getCustomer().getEmail());
			
			customerRepository.save(customer);
			
			customerFull = customerRepository.findCustomerByFirstNameAndLastName(
					inquiryDTO.getCustomer().getFirstName(), inquiryDTO.getCustomer().getLastName()).get(0);
		}
				
		inquiry.setCustomer(customerFull);
		
		InquiryReason inquiryReason = inquiryReasonRepository.findByInquiryReasonId(inquiryDTO.getInquiryReason().getInquiryReasonId()).get(0);
				
		inquiry.setInquiryReason(inquiryReason);
		
		try {
			inquiryRepository.save(inquiry);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// This method gets all of the inquiry reasons using findAll() from the inquiryReasonRepository
	// and then for each inquiryReason in the List it creates a inquiryReasonDTO and sets the inquiryReasonId
	// and optionName using that of the inquiryReason.  These inquiryReasonDTO objects are then added to the 
	// allInquiryReasonDTO List and the List is returned.
	
	@Override
	public List<InquiryReasonDTO> getAllInquiryReason() {
		List<InquiryReason> allInquiryReason = inquiryReasonRepository.findAll();
		List<InquiryReasonDTO> allInquiryReasonDTO = new ArrayList<InquiryReasonDTO>();
		
		for (InquiryReason inquiryReason : allInquiryReason) {
			InquiryReasonDTO inquiryReasonDTO = new InquiryReasonDTO();
			inquiryReasonDTO.setInquiryReasonId(inquiryReason.getInquiryReasonId());
			inquiryReasonDTO.setOptionName(inquiryReason.getOptionName());
			
			allInquiryReasonDTO.add(inquiryReasonDTO);
		}
		
		return allInquiryReasonDTO;
	}

}