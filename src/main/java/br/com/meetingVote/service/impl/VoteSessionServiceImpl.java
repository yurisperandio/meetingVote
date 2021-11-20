package br.com.meetingVote.service.impl;

import br.com.meetingVote.dto.VoteResultDTO;
import br.com.meetingVote.dto.VoteSessionDTO;
import br.com.meetingVote.model.VoteSession;
import br.com.meetingVote.repository.VoteSessionRepository;
import br.com.meetingVote.service.ItemService;
import br.com.meetingVote.service.VoteSessionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VoteSessionServiceImpl implements VoteSessionService {

    private VoteSessionRepository voteSessionRepository;
    private final ItemService itemService;

    public VoteSessionServiceImpl(VoteSessionRepository voteSessionRepository, ItemService itemService){
        this.voteSessionRepository = voteSessionRepository;
        this.itemService = itemService;
    }

    @Override
    public List<VoteSessionDTO> findAll() {
        List<VoteSession> voteSessionDTOList;
        voteSessionDTOList = voteSessionRepository.findAll();
        return voteSessionDTOList.stream().map(VoteSessionDTO::new).collect(Collectors.toList());
    }

    @Override
    public VoteSessionDTO findByIdItem(Long idItem) {
        VoteSession voteSession = voteSessionRepository.findByIdItem(idItem);
        return new VoteSessionDTO(voteSession);
    }

    @Override
    public VoteSessionDTO findByIdSession(Long idSession) {
        VoteSession voteSession = voteSessionRepository.findByIdSession(idSession);
        return new VoteSessionDTO(voteSession);
    }

    @Override
    public VoteSessionDTO createSession(VoteSessionDTO voteSessionDTO) {
        VoteSession voteSession = new VoteSession(voteSessionDTO);
        Date finalEndTime;
        Calendar calendar = Calendar.getInstance();
        Long endTime = calendar.getTimeInMillis();
        voteSession.setStartDate(calendar.getTime());
        if(itemService.getItemById(voteSessionDTO.getIdItem()) != null){
            if(voteSessionDTO.getDuration() == null) {
                voteSession.setDuration(1);
                endTime = calendar.getTimeInMillis();
                finalEndTime = new Date(endTime + (voteSession.getDuration() * 60 * 1000));
                voteSession.setEndDate(finalEndTime);
                VoteSession voteSessionSaved = voteSessionRepository.save(voteSession);
                return new VoteSessionDTO(voteSessionSaved);
            }
        }
        finalEndTime = new Date(endTime + (voteSessionDTO.getDuration() * 60 * 1000));
        voteSession.setEndDate(finalEndTime);
        VoteSession voteSessionSaved = voteSessionRepository.save(voteSession);
        return new VoteSessionDTO(voteSessionSaved);
    }

    @Override
    public VoteSessionDTO totalVote(Long idSession, VoteSessionDTO voteSessionDTO) {
        VoteSession voteSession = voteSessionRepository.findByIdSession(idSession);
        voteSession.setTotalVote(voteSession.getTotalVote()+1);
        VoteSession voteSessionSaved = voteSessionRepository.save(voteSession);
        return new VoteSessionDTO(voteSessionSaved);
    }

    @Override
    public VoteSessionDTO totalYes(Long idSession, VoteSessionDTO voteSessionDTO) {
        VoteSession voteSession = voteSessionRepository.findByIdSession(idSession);
        voteSession.setTotalYes(voteSession.getTotalYes()+1);
        VoteSession voteSessionSaved = voteSessionRepository.save(voteSession);
        return new VoteSessionDTO(voteSessionSaved);
    }

    @Override
    public VoteSessionDTO totalNo(Long idSession, VoteSessionDTO voteSessionDTO) {
        VoteSession voteSession = voteSessionRepository.findByIdSession(idSession);
        voteSession.setTotalNo(voteSession.getTotalNo()+1);
        VoteSession voteSessionSaved = voteSessionRepository.save(voteSession);
        return new VoteSessionDTO(voteSessionSaved);
    }

    @Override
    public VoteResultDTO result(Long idSession) {
        VoteSession voteSession = voteSessionRepository.findByIdSession(idSession);
        return new VoteResultDTO(voteSession);
    }

    @Override
    public VoteSessionDTO updateSession(Long id, VoteSessionDTO voteSessionDTO) {
        VoteSession voteSession = voteSessionRepository.findByIdSession(id);
        voteSession.setDuration(voteSessionDTO.getDuration());
        voteSession.setStartDate(voteSessionDTO.getStartDate());
        voteSession.setEndDate(voteSessionDTO.getEndDate());
        voteSession.setIdItem(voteSessionDTO.getIdItem());
        VoteSession voteSessionSaved = voteSessionRepository.save(voteSession);
        return new VoteSessionDTO(voteSessionSaved);
    }

    @Override
    public void deleteSession(Long id) {
        voteSessionRepository.deleteById(id);
    }


}
