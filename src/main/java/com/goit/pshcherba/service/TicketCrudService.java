package com.goit.pshcherba.service;

import com.goit.pshcherba.conf.HibernateUtil;
import com.goit.pshcherba.dao.TicketDAO;
import com.goit.pshcherba.domain.Ticket;

public class TicketCrudService extends GenericCrudService<Ticket> {
    public TicketCrudService() {
        super(new TicketDAO(HibernateUtil.getSessionFactory()));
    }
}
