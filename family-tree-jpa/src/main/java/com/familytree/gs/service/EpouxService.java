package com.familytree.gs.service;

import com.familytree.gs.model.Epoux;

public interface EpouxService extends GenericService<Epoux> {

	Epoux duplicateById(long id);

}
