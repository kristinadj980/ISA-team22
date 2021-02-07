package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.NotificationRepository;
import ISA.Team22.Service.IService.INotificationService;

@Service
public class NotificationService implements INotificationService {

	@Autowired
	private  NotificationRepository notificationRepository;
}
