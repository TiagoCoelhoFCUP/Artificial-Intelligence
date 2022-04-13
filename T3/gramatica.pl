
sentence(sentence(N,V)) --> noun_phrase(N), verbal_phrase(V).
sentenca(sentenca(NP,VP)) --> noun_phrase_p(NP), verbal_phrase_p(VP).

noun_phrase(noun_phrase(Determiner, Name)) --> determiner_m(Determiner), name_m(Name).
noun_phrase(noun_phrase(Determiner, Name)) --> determiner_f(Determiner), name_f(Name).

noun_phrase(noun_phrase(Contra, Name)) --> contraction_m(Contra), name_m(Name).
noun_phrase(noun_phrase(Contra, Name)) --> contraction_f(Contra), name_f(Name).

noun_phrase_p(noun_phrase_p(Determiner, Name)) --> determiner_p_m(Determiner), name_p_m(Name).
noun_phrase_p(noun_phrase_p(Determiner, Name)) --> determiner_p_f(Determiner), name_p_f(Name).

noun_phrase_p(noun_phrase_p(Contra, Name)) --> contraction_p_m(Contra), name_p_m(Name).
noun_phrase_p(noun_phrase_p(Contra, Name)) --> contraction_p_f(Contra), name_p_f(Name).

prep_phrase(prep_phrase(Preposition,Phrase)) --> prep(Preposition), noun_phrase(Phrase).
prep_phrase(prep_phrase(Preposition,Phrase)) --> prep(Preposition), noun_phrase_p(Phrase).

verbal_phrase(verbal_phrase(Verb,Rest)) --> verb(Verb), noun_phrase(Rest).
verbal_phrase(verbal_phrase(Verb,Rest)) --> verb(Verb), noun_phrase_p(Rest).
verbal_phrase(verbal_phrase(Verb,Rest)) --> verb(Verb), prep_phrase(Rest).
verbal_phrase(verbal_phrase(Verb)) --> verb(Verb).

verbal_phrase_p(verbal_phrase_p(Verb,Rest)) --> verb_p(Verb), noun_phrase(Rest).
verbal_phrase_p(verbal_phrase_p(Verb,Rest)) --> verb_p(Verb), noun_phrase_p(Rest).
verbal_phrase_p(verbal_phrase_p(Verb,Rest)) --> verb_p(Verb), prep_phrase(Rest).
verbal_phrase_p(verbal_phrase_p(Verb)) --> verb_p(Verb).


name_m(name(cacador)) --> [cacador].
name_m(name(cachorro)) --> [cachorro].
name_m(name(rio)) --> [rio].
name_m(name(mar)) --> [mar].
name_m(name(tempo)) --> [tempo].
name_m(name(sino)) --> [sino].
name_m(name(vento)) --> [vento].
name_m(name(martelo)) --> [martelo].
name_m(name(tambor)) --> [tambor].
name_m(name(rosto)) --> [rosto].

name_f(name(menina)) --> [menina].
name_f(name(noticia)) --> [noticia].
name_f(name(floresta)) --> [floresta].
name_f(name(porta)) --> [porta].
name_f(name(vida)) --> [vida].
name_f(name(mae)) --> [mae].
name_f(name(cidade)) --> [cidade].

name_p_m(name(lobos)) --> [lobos].
name_p_m(name(tambores)) --> [tambores].

name_p_f(name(meninas)) --> [meninas].
name_p_f(name(lagrimas)) --> [lagrimas].

verb(verb(corre)) --> [corre].
verb(verb(correu)) --> [correu].
verb(verb(bateu)) --> [bateu].

verb_p(verb_p(corriam)) --> [corriam].
verb_p(verb_p(bateram)) --> [bateram].
verb_p(verb_p(correram)) --> [correram].

prep(preposition(para)) --> [para].
prep(preposition(com)) --> [com].

contraction_f(contraction(na)) --> [na].
contraction_f(contraction(pela)) --> [pela].

contraction_m(contraction(no)) --> [no].
contraction_m(contracion(pelo)) --> [pelo].

contraction_p_m(contraction(nos)) --> [nos].
contraction_p_m(contraction(pelos)) --> [pelos].

contraction_p_f(contraction(nas)) --> [nas].
contraction_p_f(contraction(pelas)) --> [pelas].

determiner_m(determiner(o)) --> [o].
determiner_m(determiner('O')) --> ['O'].

determiner_f(determiner(a)) --> [a].
determiner_f(determiner('A')) --> ['A'].

determiner_p_m(determiner(os)) --> [os].
determiner_p_m(determiner('Os')) --> ['Os'].

determiner_p_f(determiner(as)) --> [as].
determiner_p_f(determiner('As')) --> ['As'].
