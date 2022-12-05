package com.kodlamaio.bootCampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.BlacklistService;
import com.kodlamaio.bootCampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootCampProject.business.constants.MessagesForBlacklist;
import com.kodlamaio.bootCampProject.business.requests.blacklist.CreateBlacklistRequest;
import com.kodlamaio.bootCampProject.business.requests.blacklist.UpdateBlacklistRequest;
import com.kodlamaio.bootCampProject.business.responses.blacklist.CreateBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.GetAllBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.GetBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.UpdateBlacklistResponse;
import com.kodlamaio.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.BlacklistRepository;
import com.kodlamaio.bootCampProject.entities.evaluations.Blacklist;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BlacklistManager implements BlacklistService {
	BlacklistRepository blacklistRepository;
	ModelMapperService modelMapperService;
	ApplicantService applicantService;

	@Override
	public DataResult<List<GetAllBlacklistResponse>> getAll() {
		List<Blacklist> blacklists = blacklistRepository.findAll();
		List<GetAllBlacklistResponse> blacklistResponses = blacklists.stream()
				.map(blacklist -> modelMapperService.forResponse().map(blacklists, GetAllBlacklistResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllBlacklistResponse>>(blacklistResponses);
	}

	@Override
	public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createRequest) {
		checkIfApplicantExistsById(createRequest.getApplicantId());
		checkIfApplicantInBlacklistById(createRequest.getApplicantId());
		Blacklist blacklist = modelMapperService.forRequest().map(createRequest, Blacklist.class);
		blacklistRepository.save(blacklist);
		CreateBlacklistResponse blacklistResponse = modelMapperService.forResponse().map(blacklist, CreateBlacklistResponse.class);
		return new SuccessDataResult<CreateBlacklistResponse>(blacklistResponse, MessagesForBlacklist.BlacklistCreated);
	}

	@Override
	public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateRequest) {
		checkIfBlacklistExistsById(updateRequest.getId());
		Blacklist blacklist = modelMapperService.forRequest().map(updateRequest, Blacklist.class);
		blacklistRepository.save(blacklist);
		UpdateBlacklistResponse blacklistResponse = modelMapperService.forResponse().map(blacklist, UpdateBlacklistResponse.class);
		return new SuccessDataResult<UpdateBlacklistResponse>(blacklistResponse, MessagesForBlacklist.BlacklistUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfBlacklistExistsById(id);
		blacklistRepository.deleteById(id);
		return new SuccessResult(MessagesForBlacklist.BlacklistDeleted);
	}

	@Override
	public DataResult<GetBlacklistResponse> getById(int id) {
		checkIfBlacklistExistsById(id);
		Blacklist blacklist = blacklistRepository.findById(id).orElse(null);
		GetBlacklistResponse blacklistResponse = modelMapperService.forResponse().map(blacklist, GetBlacklistResponse.class);
		return new SuccessDataResult<GetBlacklistResponse>(blacklistResponse);
	}

	@Override
	public DataResult<GetBlacklistResponse> getByApplicantId(int applicantId) {
		checkIfApplicantExistsInBlackistById(applicantId);
		Blacklist blacklist = blacklistRepository.findByApplicantId(applicantId);
		GetBlacklistResponse blacklistResponse = modelMapperService.forResponse().map(blacklist, GetBlacklistResponse.class);
		return new SuccessDataResult<GetBlacklistResponse>(blacklistResponse);
	}
	
	/// Rules For External Requests \\\
	
	@Override
	public void checkIfApplicantInBlacklistById(int id) {
		if(blacklistRepository.findByApplicantId(id) != null) {
			throw new BusinessException(MessagesForBlacklist.ApplicantExistInList);
		}
	}
	
	/// Domain Rules \\\
	
	private void checkIfBlacklistExistsById(int id) {
		if(blacklistRepository.findById(id) == null) {
			throw new BusinessException(MessagesForBlacklist.BlacklistDoesNotExistById);
		}
	}
	
	private void checkIfApplicantExistsById(int id) {
		applicantService.getById(id);
	}
	
	private void checkIfApplicantExistsInBlackistById(int id) {
		if(blacklistRepository.findByApplicantId(id) == null) {
			throw new BusinessException(MessagesForBlacklist.ApplicantNotExistInList);
		}
	}
	
}
