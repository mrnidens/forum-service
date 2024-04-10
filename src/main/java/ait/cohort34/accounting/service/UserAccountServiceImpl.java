package ait.cohort34.accounting.service;

import ait.cohort34.accounting.dao.AccountRepository;
import ait.cohort34.accounting.dto.RolesDto;
import ait.cohort34.accounting.dto.UserDto;
import ait.cohort34.accounting.dto.UserEditDto;
import ait.cohort34.accounting.dto.UserRegisterDto;
import ait.cohort34.accounting.dto.exceptions.UserNotFoundException;
import ait.cohort34.accounting.model.UserAccount;
import ait.cohort34.post.dto.PostDto;
import ait.cohort34.post.dto.exceptions.PostNotFoundException;
import ait.cohort34.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    final AccountRepository accountRepository;
    final ModelMapper modelMapper;

    @Override
    public UserDto register(UserRegisterDto userRegisterDto) {
        UserAccount userAccount = modelMapper.map(userRegisterDto, UserAccount.class);
        userAccount.addRole("USER");
        accountRepository.save(userAccount);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Override
    public UserDto getUser(String login) {
        UserAccount userAccount = accountRepository.findById(login).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Override
    public UserDto removeUser(String login) {
        UserAccount userAccount = accountRepository.findById(login).orElseThrow(PostNotFoundException::new);
        accountRepository.delete(userAccount);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Override
    public UserDto updateUser(String login, UserEditDto userEditDto) {
        UserAccount userAccount = accountRepository.findById(login).orElseThrow(UserNotFoundException::new);
        String firstName = userEditDto.getFirstName();
        if (firstName != null ) {
            userAccount.setFirstName(firstName);
        }
        String lastName = userEditDto.getLastName();
        if (lastName != null ) {
            userAccount.setLastName(lastName);
        }
        accountRepository.save(userAccount);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Override
    public RolesDto changeRolesList(String login, String role, boolean isAddRole) {
        return null;
    }

    @Override
    public void changePassword(String login, String newPassword) {
//TODO
    }
}
